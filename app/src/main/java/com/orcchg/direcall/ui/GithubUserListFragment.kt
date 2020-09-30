package com.orcchg.direcall.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.orcchg.direcall.R
import com.orcchg.direcall.adapter.GithubUserListAdapter
import com.orcchg.direcall.androidutil.observe
import com.orcchg.direcall.androidutil.SchedulersFactoryImpl
import com.orcchg.direcall.base.usecase.UseCaseThreadExecutor
import com.orcchg.direcall.data.convert.GithubRepoCloudConverter
import com.orcchg.direcall.data.convert.GithubUserCloudConverter
import com.orcchg.direcall.data.convert.GithubUserDetailsCloudConverter
import com.orcchg.direcall.data.remote.CloudModule
import com.orcchg.direcall.data.repository.GithubRepositoryImpl
import com.orcchg.direcall.databinding.FragmentGithubUserListBinding
import com.orcchg.direcall.androidutil.viewBindings
import com.orcchg.direcall.domain.usecase.GetGithubUsersUseCase
import com.orcchg.direcall.viewmodel.GithubUserListViewModel
import com.orcchg.direcall.viewmodel.GithubUserListViewModelFactory
import retrofit2.create

class GithubUserListFragment : Fragment(R.layout.fragment_github_user_list) {

    private val adapter = GithubUserListAdapter().apply {
        itemClickListener = {
            GithubUserListFragmentDirections.navActionOpenGithubUserDetails(login = it.login)
                .let(findNavController()::navigate)
        }
    }
    private val binding by viewBindings(FragmentGithubUserListBinding::bind)
    private val factory by lazy(LazyThreadSafetyMode.NONE) {
        val logger = CloudModule.loggingInterceptor()
        val moshi = CloudModule.moshi()
        val okHttpClient = CloudModule.okHttpClient(logger)
        val retrofit = CloudModule.retrofit(okHttpClient, moshi)

        GithubUserListViewModelFactory(
            getGithubUsersUseCase = GetGithubUsersUseCase(
                repository = GithubRepositoryImpl(
                    repoCloud = retrofit.create(),
                    userCloud = retrofit.create(),
                    repoConverter = GithubRepoCloudConverter(),
                    userConverter = GithubUserCloudConverter(),
                    userDetailsConverter = GithubUserDetailsCloudConverter()
                ),
                schedulersFactory = SchedulersFactoryImpl(
                    useCaseExecutor = UseCaseThreadExecutor()
                )
            )
        )
    }
    private val viewModel by viewModels<GithubUserListViewModel> { factory }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvUsers.adapter = adapter

        observe(viewModel.users, adapter::update)
    }
}
