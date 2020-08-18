package com.orcchg.direcall.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.jakewharton.rxbinding4.view.clicks
import com.orcchg.direcall.R
import com.orcchg.direcall.androidutil.observe
import com.orcchg.direcall.databinding.FragmentGithubUserDetailsBinding
import com.orcchg.direcall.viewBindings
import com.orcchg.direcall.viewmodel.GithubUserDetailsViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import java.util.concurrent.TimeUnit

class GithubUserDetailsFragment : Fragment(R.layout.fragment_github_user_details) {

    private val binding by viewBindings(FragmentGithubUserDetailsBinding::bind)
    private val viewModel by viewModels<GithubUserDetailsViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val login = arguments?.getString("login") ?: throw NullPointerException("Missing 'login' argument")

        binding.btnRepoList.clicks()
            .debounce(200L, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread())
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
