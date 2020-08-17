package com.orcchg.direcall.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.orcchg.direcall.R
import com.orcchg.direcall.databinding.FragmentGithubRepoListBinding
import com.orcchg.direcall.viewBindings
import com.orcchg.direcall.viewmodel.GithubRepoViewModel

class GithubRepoFragment : Fragment(R.layout.fragment_github_repo_list) {

    val binding by viewBindings(FragmentGithubRepoListBinding::bind)
    val viewModel by viewModels<GithubRepoViewModel>()
}
