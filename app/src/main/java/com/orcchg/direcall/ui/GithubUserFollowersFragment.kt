package com.orcchg.direcall.ui

import android.content.Context
import android.graphics.Rect
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.orcchg.direcall.R
import com.orcchg.direcall.adapter.GithubUserFollowersAdapter
import com.orcchg.direcall.androidutil.argument
import com.orcchg.direcall.androidutil.observe
import com.orcchg.direcall.androidutil.viewBindings
import com.orcchg.direcall.databinding.FragmentGithubUserFollowerListBinding
import com.orcchg.direcall.domain.usecase.GetGithubUserFollowersUseCase
import com.orcchg.direcall.viewmodel.GithubUserFollowersListModelFactory
import com.orcchg.direcall.viewmodel.GithubUserFollowersListViewModel
import javax.inject.Inject

class GithubUserFollowersFragment : BaseFragment(R.layout.fragment_github_user_follower_list) {

    override fun onAttach(context: Context) {
        githubUserFollowersComponent.inject(this)
        super.onAttach(context)
    }

    private val binding by viewBindings(FragmentGithubUserFollowerListBinding::bind)
    private val login by argument<String>("login")

    @Inject lateinit var useCase: GetGithubUserFollowersUseCase

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