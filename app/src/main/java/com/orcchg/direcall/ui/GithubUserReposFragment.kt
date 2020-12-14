package com.orcchg.direcall.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.orcchg.direcall.R
import com.orcchg.direcall.adapter.GithubUserReposAdapter
import com.orcchg.direcall.androidutil.SchedulersFactoryImpl
import com.orcchg.direcall.androidutil.argument
import com.orcchg.direcall.androidutil.observe
import com.orcchg.direcall.androidutil.viewBindings
import com.orcchg.direcall.base.usecase.UseCaseThreadExecutor
import com.orcchg.direcall.data.convert.*
import com.orcchg.direcall.data.remote.CloudModule
import com.orcchg.direcall.data.remote.GithubUserCloudRest
import com.orcchg.direcall.data.repository.GithubRepositoryImpl
import com.orcchg.direcall.databinding.FragmentGithubUserRepoListBinding
import com.orcchg.direcall.domain.usecase.GetGithubUserRepoUseCase
import com.orcchg.direcall.viewmodel.GithubUserReposViewModel
import com.orcchg.direcall.viewmodel.GithubUserReposViewModelFactory
import retrofit2.create

class GithubUserReposFragment : Fragment(R.layout.fragment_github_user_repo_list) {
    private val binding by viewBindings(FragmentGithubUserRepoListBinding::bind)
    private val login by argument<String>("login")
    private val executor = UseCaseThreadExecutor()
    private val retrofit = CloudModule.retrofit(
        CloudModule.okHttpClient(CloudModule.loggingInterceptor()),
        CloudModule.moshi()
    )
    private val userCloud: GithubUserCloudRest = retrofit.create()
    private val userDetailsConverter = GithubUserDetailsCloudConverter()
    private val userListConverter = GithubUserListCloudConverter()
    private val userRepoListConverter = GithubUserRepoCloudConverter()
    private val userGistListConverter = GithubUserGistCloudConverter()
    private val userFollowersCloudConverter = GithubUserFollowersCloudConverter()
    private val scheduler = SchedulersFactoryImpl(executor)
    private val gitRepo = GithubRepositoryImpl(
        userCloud = userCloud,
        userDetailsConverter = userDetailsConverter,
        userListConverter = userListConverter,
        userRepoListConverter = userRepoListConverter,
        userGistListCloudConverter = userGistListConverter,
        userFollowersCloudConverter = userFollowersCloudConverter
    )
    private val userCase = GetGithubUserRepoUseCase(gitRepo, scheduler)
    private val myFactory by lazy { GithubUserReposViewModelFactory(login, userCase) }
    private val viewModel: GithubUserReposViewModel by viewModels { myFactory }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = GithubUserReposAdapter()
        binding.rvRepoItems.adapter = adapter

        observe(viewModel.userReposList, adapter::update)
    }
}