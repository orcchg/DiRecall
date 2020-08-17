package com.orcchg.direcall.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.orcchg.direcall.R
import com.orcchg.direcall.databinding.FragmentGithubUserDetailsBinding
import com.orcchg.direcall.viewBindings
import com.orcchg.direcall.viewmodel.GithubUserDetailsViewModel

class GithubUserDetailsFragment : Fragment(R.layout.fragment_github_user_details) {

    val binding by viewBindings(FragmentGithubUserDetailsBinding::bind)
    val viewModel by viewModels<GithubUserDetailsViewModel>()
}
