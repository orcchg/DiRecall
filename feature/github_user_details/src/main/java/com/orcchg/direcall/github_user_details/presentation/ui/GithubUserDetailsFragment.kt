package com.orcchg.direcall.github_user_details.presentation.ui

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
import com.orcchg.direcall.di.AppCoreApi
import com.orcchg.direcall.di.getFeature
import com.orcchg.direcall.github_user_details.R
import com.orcchg.direcall.github_user_details.databinding.FragmentGithubUserDetailsBinding
import com.orcchg.direcall.github_user_details.di.DaggerGithubUserDetailsFragmentComponent
import com.orcchg.direcall.github_user_details.di.GithubUserDetailsModule
import com.orcchg.direcall.github_user_details.presentation.viewmodel.GithubUserDetailsViewModel
import com.orcchg.direcall.github_user_details.presentation.viewmodel.GithubUserDetailsViewModelFactory
import javax.inject.Inject

class GithubUserDetailsFragment : Fragment(R.layout.fragment_github_user_details) {

    @Inject lateinit var factory: GithubUserDetailsViewModelFactory

    private val binding by viewBindings(FragmentGithubUserDetailsBinding::bind)
    private val login by argument<String>("login")
    private val viewModel by viewModels<GithubUserDetailsViewModel> { factory }

    override fun onAttach(context: Context) {
        val api = (requireActivity().application as AppCoreApi)
        DaggerGithubUserDetailsFragmentComponent.factory()
            .create(
                module = GithubUserDetailsModule(login),
                networkApi = api.getFeature(),
                schedulerApi = api.getFeature()
            )
            .inject(this)
        super.onAttach(context)
    }

    @SuppressLint("AutoDispose", "CheckResult")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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
