package com.orcchg.direcall.ui

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.jakewharton.rxbinding3.view.clicks
import com.orcchg.direcall.R
import com.orcchg.direcall.androidutil.argument
import com.orcchg.direcall.androidutil.clickDebounce
import com.orcchg.direcall.androidutil.observe
import com.orcchg.direcall.androidutil.viewBindings
import com.orcchg.direcall.databinding.FragmentGithubUserDetailsBinding
import com.orcchg.direcall.di.DaggerGithubUserDetailsFeatureComponent
import com.orcchg.direcall.di.ViewModelFactoryModule
import com.orcchg.direcall.viewmodel.GithubUserDetailsViewModel
import com.orcchg.direcall.viewmodel.GithubUserDetailsViewModelFactory
import javax.inject.Inject

class GithubUserDetailsFragment : BaseFragment(R.layout.fragment_github_user_details) {

    override fun onAttach(context: Context) {
        DaggerGithubUserDetailsFeatureComponent
            .factory()
            .create(networkComponent, ViewModelFactoryModule(login))
            .inject(this)

        super.onAttach(context)
    }

    private val binding by viewBindings(FragmentGithubUserDetailsBinding::bind)
    private val login by argument<String>("login")
    @Inject lateinit var myFactory: GithubUserDetailsViewModelFactory
    private val viewModel: GithubUserDetailsViewModel by viewModels { myFactory }

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
