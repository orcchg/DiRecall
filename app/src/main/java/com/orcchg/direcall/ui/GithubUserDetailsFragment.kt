package com.orcchg.direcall.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.jakewharton.rxbinding3.view.clicks
import com.orcchg.direcall.R
import com.orcchg.direcall.androidutil.argument
import com.orcchg.direcall.androidutil.clickDebounce
import com.orcchg.direcall.androidutil.observe
import com.orcchg.direcall.androidutil.viewBindings
import com.orcchg.direcall.databinding.FragmentGithubUserDetailsBinding
import com.orcchg.direcall.viewmodel.GithubUserDetailsViewModel
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class GithubUserDetailsFragment : Fragment(R.layout.fragment_github_user_details) {
    private val binding by viewBindings(FragmentGithubUserDetailsBinding::bind)
    private val login by argument<String>("login")
    private val viewModel by viewModel<GithubUserDetailsViewModel> { parametersOf(login) }

    @SuppressLint("AutoDispose", "CheckResult")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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
