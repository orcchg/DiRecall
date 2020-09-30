package com.orcchg.direcall.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.orcchg.direcall.R
import com.orcchg.direcall.adapter.GithubRepoListAdapter
import com.orcchg.direcall.androidutil.SchedulersFactoryImpl
import com.orcchg.direcall.androidutil.argument
import com.orcchg.direcall.androidutil.observe
import com.orcchg.direcall.base.usecase.UseCaseThreadExecutor
import com.orcchg.direcall.data.convert.GithubRepoCloudConverter
import com.orcchg.direcall.data.convert.GithubUserCloudConverter
import com.orcchg.direcall.data.convert.GithubUserDetailsCloudConverter
import com.orcchg.direcall.data.remote.CloudModule
import com.orcchg.direcall.data.repository.GithubRepositoryImpl
import com.orcchg.direcall.databinding.FragmentGithubRepoListBinding
import com.orcchg.direcall.androidutil.viewBindings
import com.orcchg.direcall.domain.usecase.GetGithubReposUseCase
import com.orcchg.direcall.viewmodel.GithubRepoViewModel
import com.orcchg.direcall.viewmodel.GithubRepoViewModelFactory
import retrofit2.create

class GithubRepoFragment : Fragment(R.layout.fragment_github_repo_list) {

    private val adapter = GithubRepoListAdapter()
    private val binding by viewBindings(FragmentGithubRepoListBinding::bind)
    private val login by argument<String>("login")
    private val factory by lazy(LazyThreadSafetyMode.NONE) {
        val logger = CloudModule.loggingInterceptor()
        val moshi = CloudModule.moshi()
        val okHttpClient = CloudModule.okHttpClient(logger)
        val retrofit = CloudModule.retrofit(okHttpClient, moshi)

        GithubRepoViewModelFactory(
            login = login,
            getGithubReposUseCase = GetGithubReposUseCase(
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
    private val viewModel by viewModels<GithubRepoViewModel> { factory }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvRepos.adapter = adapter

        observe(viewModel.repos, adapter::update)
    }
}
