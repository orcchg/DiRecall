package com.orcchg.direcall.ui

import android.graphics.Rect
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.orcchg.direcall.R
import com.orcchg.direcall.adapter.GithubUserFollowersAdapter
import com.orcchg.direcall.androidutil.SchedulersFactoryImpl
import com.orcchg.direcall.androidutil.argument
import com.orcchg.direcall.androidutil.observe
import com.orcchg.direcall.androidutil.viewBindings
import com.orcchg.direcall.base.usecase.UseCaseThreadExecutor
import com.orcchg.direcall.data.convert.*
import com.orcchg.direcall.data.remote.CloudModule
import com.orcchg.direcall.data.remote.GithubUserCloudRest
import com.orcchg.direcall.data.repository.GithubRepositoryImpl
import com.orcchg.direcall.databinding.FragmentGithubUserFollowerListBinding
import com.orcchg.direcall.domain.usecase.GetGithubUserFollowersUseCase
import com.orcchg.direcall.viewmodel.GithubUserFollowersListModelFactory
import com.orcchg.direcall.viewmodel.GithubUserFollowersListViewModel
import retrofit2.create

class GithubUserFollowersFragment : Fragment(R.layout.fragment_github_user_follower_list) {
    private val binding by viewBindings(FragmentGithubUserFollowerListBinding::bind)
    private val login by argument<String>("login")
    private val executor = UseCaseThreadExecutor()
    private val retrofit = CloudModule.provideRetrofit(
        CloudModule.provideOkHttpClient(CloudModule.provideLoggingInterceptor()),
        CloudModule.provideMoshi()
    )
    private val userCloud: GithubUserCloudRest = retrofit.create()
    private val userDetailsConverter = GithubUserDetailsCloudConverter()
    private val userListConverter = GithubUserListCloudConverter()
    private val userRepoListConverter = GithubUserRepoCloudConverter()
    private val userGistCloudConverter = GithubUserGistCloudConverter()
    private val userFollowersCloudConverter = GithubUserFollowersCloudConverter()
    private val userOrgsCloudConverter = GithubUserOrgsCloudConverter()
    private val scheduler = SchedulersFactoryImpl(executor)
    private val gitRepo = GithubRepositoryImpl(
        userCloud = userCloud,
        userDetailsConverter = userDetailsConverter,
        userListConverter = userListConverter,
        userRepoListConverter = userRepoListConverter,
        userGistListCloudConverter = userGistCloudConverter,
        userFollowersCloudConverter = userFollowersCloudConverter,
        userOrgsCloudConverter = userOrgsCloudConverter
    )
    private val useCase = GetGithubUserFollowersUseCase(gitRepo, scheduler)
    private val myFactory by lazy { GithubUserFollowersListModelFactory(login, useCase) }
    private val viewModel: GithubUserFollowersListViewModel by viewModels { myFactory }

    private val layoutManager = LinearLayoutManager(activity)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = GithubUserFollowersAdapter()
        binding.rvFollowersItems.adapter = adapter

        binding.rvFollowersItems.addItemDecoration(object :
            DividerItemDecoration(requireContext(), layoutManager.orientation) {
            override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
                outRect.top = layoutManager.paddingTop
                outRect.bottom = layoutManager.paddingBottom
            }
        })

        observe(viewModel.followersList, adapter::update)
    }
}