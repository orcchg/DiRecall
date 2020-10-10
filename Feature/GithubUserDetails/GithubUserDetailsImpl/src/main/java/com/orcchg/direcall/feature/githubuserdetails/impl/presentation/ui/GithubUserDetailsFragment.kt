package com.orcchg.direcall.feature.githubuserdetails.impl.presentation.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.jakewharton.rxbinding3.view.clicks
import com.orcchg.direcall.androidutil.argument
import com.orcchg.direcall.androidutil.clickDebounce
import com.orcchg.direcall.androidutil.observe
import com.orcchg.direcall.androidutil.viewBindings
import com.orcchg.direcall.core.ui.viewModels
import com.orcchg.direcall.feature.githubuserdetails.impl.R
import com.orcchg.direcall.feature.githubuserdetails.impl.databinding.FragmentGithubUserDetailsBinding
import com.orcchg.direcall.feature.githubuserdetails.impl.presentation.viewmodel.GithubUserDetailsViewModelFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class GithubUserDetailsFragment : DaggerFragment(R.layout.fragment_github_user_details) {

    @Inject lateinit var factory: GithubUserDetailsViewModelFactory

    private val binding by viewBindings(FragmentGithubUserDetailsBinding::bind)
    private val login by argument<String>("login")
    private val viewModel by viewModels(::factory)

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
