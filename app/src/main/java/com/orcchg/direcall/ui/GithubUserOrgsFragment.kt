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
import com.orcchg.direcall.adapter.GithubUserOrgsAdapter
import com.orcchg.direcall.androidutil.SchedulersFactoryImpl
import com.orcchg.direcall.androidutil.argument
import com.orcchg.direcall.androidutil.observe
import com.orcchg.direcall.androidutil.viewBindings
import com.orcchg.direcall.base.usecase.UseCaseThreadExecutor
import com.orcchg.direcall.data.convert.*
import com.orcchg.direcall.data.remote.CloudModule
import com.orcchg.direcall.data.remote.GithubUserCloudRest
import com.orcchg.direcall.data.repository.GithubRepositoryImpl
import com.orcchg.direcall.databinding.FragmentGithubUserOrgsListBinding
import com.orcchg.direcall.domain.usecase.GetGithubUserOrgsUseCase
import com.orcchg.direcall.viewmodel.GithubUserOrgsListViewModel
import com.orcchg.direcall.viewmodel.GithubUserOrgsListViewModelFactory
import retrofit2.create

class GithubUserOrgsFragment : Fragment(R.layout.fragment_github_user_orgs_list) {
    private val binding by viewBindings(FragmentGithubUserOrgsListBinding::bind)
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
    private val useCase = GetGithubUserOrgsUseCase(gitRepo, scheduler)
    private val myFactory by lazy { GithubUserOrgsListViewModelFactory(login, useCase) }
    private val viewModel: GithubUserOrgsListViewModel by viewModels { myFactory }

    private val layoutManager = LinearLayoutManager(activity)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = GithubUserOrgsAdapter()
        binding.rvOrganizationsItems.adapter = adapter

        binding.rvOrganizationsItems.addItemDecoration(object :
            DividerItemDecoration(requireContext(), layoutManager.orientation) {
            override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
                outRect.top = layoutManager.paddingTop
                outRect.bottom = layoutManager.paddingBottom
            }
        })

        observe(viewModel.orgsList, adapter::update)
    }
}