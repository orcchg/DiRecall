package com.orcchg.direcall.feature.github_user_details.dfm.presentation.ui

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.jakewharton.rxbinding3.view.clicks
import com.orcchg.direcall.androidutil.argument
import com.orcchg.direcall.androidutil.clickDebounce
import com.orcchg.direcall.androidutil.observe
import com.orcchg.direcall.androidutil.viewBindings
import com.orcchg.direcall.core.di.FeatureContainer
import com.orcchg.direcall.core.di.getFeature
import com.orcchg.direcall.feature.github_user_details.dfm.R
import com.orcchg.direcall.feature.github_user_details.dfm.databinding.FragmentGithubUserDetailsBinding
import com.orcchg.direcall.feature.github_user_details.dfm.di.DaggerGithubUserDetailsFragmentComponent
import com.orcchg.direcall.feature.github_user_details.dfm.presentation.viewmodel.GithubUserDetailsViewModel
import com.orcchg.direcall.feature.github_user_details.dfm.presentation.viewmodel.GithubUserDetailsViewModelFactory
import javax.inject.Inject

class GithubUserDetailsFragment : Fragment(R.layout.fragment_github_user_details) {

    @Inject lateinit var factory: GithubUserDetailsViewModelFactory

    private val binding by viewBindings(FragmentGithubUserDetailsBinding::bind)
    private val login by argument<String>("login")
    private val viewModel by viewModels<GithubUserDetailsViewModel> { factory }

    override fun onAttach(context: Context) {
        val featureContainer = (requireActivity().application as FeatureContainer)

        DaggerGithubUserDetailsFragmentComponent.factory()
            .create(
                login = login,
                analyticsCoreLibApi = featureContainer.getFeature(),
                githubUserDetailsFeatureApi = featureContainer.getFeature()
            )
            .inject(this)
        super.onAttach(context)
    }

    @SuppressLint("AutoDispose", "CheckResult")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnFollowerList.clicks().clickDebounce()
            .subscribe {
                GithubUserDetailsFragmentDirections.navActionOpenGithubFollowerList(login = login)
                    .let(findNavController()::navigate)
            }

        binding.btnGistList.clicks().clickDebounce()
            .subscribe {
                GithubUserDetailsFragmentDirections.navActionOpenGithubGistList(login = login)
                    .let(findNavController()::navigate)
            }

        binding.btnOrganizationList.clicks().clickDebounce()
            .subscribe {
                GithubUserDetailsFragmentDirections.navActionOpenGithubOrganizationList(login = login)
                    .let(findNavController()::navigate)
            }

        binding.btnRepoList.clicks().clickDebounce()
            .subscribe {
                GithubUserDetailsFragmentDirections.navActionOpenGithubRepoList(login = login)
                    .let(findNavController()::navigate)
            }

        observe(viewModel.user) {
            Glide.with(this)
                .load(it.avatarUrl)
                .into(binding.ivAvatar)

            binding.tvTitle.text = it.login
        }
    }
}
