package com.orcchg.direcall.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.orcchg.direcall.R
import com.orcchg.direcall.androidutil.observe
import com.orcchg.direcall.databinding.FragmentGithubUserDetailsBinding
import com.orcchg.direcall.viewBindings
import com.orcchg.direcall.viewmodel.GithubUserDetailsViewModel

class GithubUserDetailsFragment : Fragment(R.layout.fragment_github_user_details) {

    private val binding by viewBindings(FragmentGithubUserDetailsBinding::bind)
    private val viewModel by viewModels<GithubUserDetailsViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observe(viewModel.user) {
            Glide.with(this)
                .load(it.avatarUrl)
                .into(binding.ivAvatar)

            binding.tvTitle.text = it.login
        }
    }
}
