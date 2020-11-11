package com.orcchg.direcall.feature.github_user_profile.dfm.presentation.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.orcchg.direcall.androidutil.argument
import com.orcchg.direcall.androidutil.observe
import com.orcchg.direcall.androidutil.viewBindings
import com.orcchg.direcall.core.di.FeatureContainer
import com.orcchg.direcall.core.di.getFeature
import com.orcchg.direcall.feature.github_user_profile.dfm.R
import com.orcchg.direcall.feature.github_user_profile.dfm.databinding.FragmentUserProfileBinding
import com.orcchg.direcall.feature.github_user_profile.dfm.di.DaggerGithubUserProfileFragmentComponent
import com.orcchg.direcall.feature.github_user_profile.dfm.presentation.adapter.GithubOrganizationsAdapter
import com.orcchg.direcall.feature.github_user_profile.dfm.presentation.adapter.GithubProjectListAdapter
import com.orcchg.direcall.feature.github_user_profile.dfm.presentation.adapter.GithubRepoListAdapter
import com.orcchg.direcall.feature.github_user_profile.dfm.presentation.viewmodel.GithubUserProfileViewModel
import com.orcchg.direcall.feature.github_user_profile.dfm.presentation.viewmodel.GithubUserProfileViewModelFactory
import javax.inject.Inject

class GithubUserProfileFragment : Fragment(R.layout.fragment_user_profile) {

    @Inject lateinit var factory: GithubUserProfileViewModelFactory

    private val organizationsAdapter = GithubOrganizationsAdapter()
    private val projectsAdapter = GithubProjectListAdapter()
    private val reposAdapter = GithubRepoListAdapter()

    private val binding by viewBindings(FragmentUserProfileBinding::bind)
    private val login by argument<String>("login")
    private val viewModel by viewModels<GithubUserProfileViewModel> { factory }

    override fun onAttach(context: Context) {
        val featureContainer = (requireActivity().application as FeatureContainer)

        DaggerGithubUserProfileFragmentComponent.factory()
            .create(
                login = login,
                analyticsCoreLibApi = featureContainer.getFeature(),
                githubFollowerFeatureApi = featureContainer.getFeature(),
                githubGistFeatureApi = featureContainer.getFeature(),
                githubOrganizationFeatureApi = featureContainer.getFeature(),
                githubProfileFeatureApi = featureContainer.getFeature(),
                githubRepoFeatureApi = featureContainer.getFeature(),
                githubUserDetailsFeatureApi = featureContainer.getFeature()
            )
            .inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvOrganizations.adapter = organizationsAdapter
        binding.rvProjects.adapter = projectsAdapter
        binding.rvRepos.adapter = reposAdapter

        observe(viewModel.organizations, organizationsAdapter::update)
        observe(viewModel.projects, projectsAdapter::update)
        observe(viewModel.repos, reposAdapter::update)

        observe(viewModel.user) {
            Glide.with(this)
                .load(it.avatarUrl)
                .into(binding.ivAvatar)

            binding.tvTitle.text = it.login
        }

        observe(viewModel.counters) {
            binding.tvEvents.text = it.events.toString()
            binding.tvFollowers.text = it.followers.toString()
            binding.tvGists.text = it.gists.toString()
        }
    }
}
