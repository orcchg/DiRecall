package com.orcchg.direcall.feature.github_user_followers.dfm.presentation.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.orcchg.direcall.androidutil.argument
import com.orcchg.direcall.androidutil.observe
import com.orcchg.direcall.androidutil.viewBindings
import com.orcchg.direcall.core.di.FeatureContainer
import com.orcchg.direcall.core.di.getFeature
import com.orcchg.direcall.feature.github_user_followers.dfm.R
import com.orcchg.direcall.feature.github_user_followers.dfm.databinding.FragmentGithubFollowerListBinding
import com.orcchg.direcall.feature.github_user_followers.dfm.di.DaggerGithubUserFollowersFragmentComponent
import com.orcchg.direcall.feature.github_user_followers.dfm.presentation.adapter.GithubFollowersAdapter
import com.orcchg.direcall.feature.github_user_followers.dfm.presentation.viewmodel.GithubUserFollowersViewModel
import com.orcchg.direcall.feature.github_user_followers.dfm.presentation.viewmodel.GithubUserFollowersViewModelFactory
import javax.inject.Inject

class GithubUserFollowersFragment : Fragment(R.layout.fragment_github_follower_list) {

    @Inject lateinit var factory: GithubUserFollowersViewModelFactory

    private val adapter = GithubFollowersAdapter().apply {
        itemClickListener = {
            GithubUserFollowersFragmentDirections.navActionOpenGithubFollowerDetails(login = it.login)
                .let(findNavController()::navigate)
        }
    }
    private val binding by viewBindings(FragmentGithubFollowerListBinding::bind)
    private val login by argument<String>("login")
    private val viewModel by viewModels<GithubUserFollowersViewModel> { factory }

    override fun onAttach(context: Context) {
        val featureContainer = (requireActivity().application as FeatureContainer)

        DaggerGithubUserFollowersFragmentComponent.factory()
            .create(
                login = login,
                analyticsCoreLibApi = featureContainer.getFeature(),
                githubFollowerFeatureApi = featureContainer.getFeature()
            )
            .inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvFollowers.adapter = adapter

        observe(viewModel.followers, adapter::update)
    }
}
