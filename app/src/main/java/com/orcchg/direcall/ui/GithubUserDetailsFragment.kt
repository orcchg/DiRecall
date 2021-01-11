package com.orcchg.direcall.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.jakewharton.rxbinding3.view.clicks
import com.orcchg.direcall.App
import com.orcchg.direcall.R
import com.orcchg.direcall.androidutil.argument
import com.orcchg.direcall.androidutil.clickDebounce
import com.orcchg.direcall.androidutil.observe
import com.orcchg.direcall.androidutil.viewBindings
import com.orcchg.direcall.databinding.FragmentGithubUserDetailsBinding
import com.orcchg.direcall.domain.usecase.GetGithubUserDetailsUseCase
import com.orcchg.direcall.viewmodel.GithubUserDetailsViewModel
import com.orcchg.direcall.viewmodel.GithubUserDetailsViewModelFactory

class GithubUserDetailsFragment : Fragment(R.layout.fragment_github_user_details) {
    private val binding by viewBindings(FragmentGithubUserDetailsBinding::bind)
    private val login by argument<String>("login")
    private lateinit var app: App
    private val useCase by lazy {
        app.serviceLocator[GetGithubUserDetailsUseCase::class.java] as GetGithubUserDetailsUseCase
    }
    private val myFactory by lazy { GithubUserDetailsViewModelFactory(login, useCase) }
    private val viewModel: GithubUserDetailsViewModel by viewModels { myFactory }

    @SuppressLint("AutoDispose", "CheckResult")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        app = requireActivity().application as App

        binding.btnRepoList.clicks().clickDebounce()
            .subscribe {
                val action = GithubUserDetailsFragmentDirections
                    .actionNavFragmentGithubUserDetailsToNavFragmentGithubRepoList(login)
                Navigation.findNavController(binding.root).navigate(action)
            }

        binding.btnGistList.clicks().clickDebounce()
            .subscribe {
                val action = GithubUserDetailsFragmentDirections
                    .actionNavFragmentGithubUserDetailsToNavFragmentGithubGistList(login)
                Navigation.findNavController(binding.root).navigate(action)
            }

        binding.btnFollowersList.clicks().clickDebounce()
            .subscribe {
                val action = GithubUserDetailsFragmentDirections
                    .actionNavFragmentGithubUserDetailsToNavFragmentGithubFolowersList(login)
                Navigation.findNavController(binding.root).navigate(action)
            }

        binding.btnOrgsList.clicks().clickDebounce()
            .subscribe {
                val action = GithubUserDetailsFragmentDirections
                    .actionNavFragmentGithubUserDetailsToNavFragmentGithubOrgsList(login)
                Navigation.findNavController(binding.root).navigate(action)
            }

        observe(viewModel.user) {
            Glide.with(this)
                .load(it.avatarUrl)
                .into(binding.ivAvatar)

            binding.tvTitle.text = it.login
        }
    }
}
