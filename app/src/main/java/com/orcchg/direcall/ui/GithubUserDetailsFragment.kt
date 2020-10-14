package com.orcchg.direcall.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.jakewharton.rxbinding3.view.clicks
import com.orcchg.direcall.R
import com.orcchg.direcall.androidutil.argument
import com.orcchg.direcall.androidutil.clickDebounce
import com.orcchg.direcall.androidutil.observe
import com.orcchg.direcall.databinding.FragmentGithubUserDetailsBinding
import com.orcchg.direcall.androidutil.viewBindings
import com.orcchg.direcall.base.BaseFragment
import com.orcchg.direcall.viewmodel.GithubUserDetailsViewModel
import com.orcchg.direcall.viewmodel.GithubUserDetailsViewModelFactory

class GithubUserDetailsFragment : BaseFragment(R.layout.fragment_github_user_details) {

    private val binding by viewBindings(FragmentGithubUserDetailsBinding::bind)
    private val login by argument<String>("login")
    private val factory by lazy(LazyThreadSafetyMode.NONE) {
        GithubUserDetailsViewModelFactory(login, serviceLocator.githubUserDetailsUseCase)
    }
    private val viewModel by viewModels<GithubUserDetailsViewModel> { factory }

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
