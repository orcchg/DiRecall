package com.orcchg.direcall.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.orcchg.direcall.R
import com.orcchg.direcall.databinding.FragmentGithubUserListBinding
import com.orcchg.direcall.viewBindings
import com.orcchg.direcall.viewmodel.GithubUserListViewModel

class GithubUserListFragment : Fragment(R.layout.fragment_github_user_list) {

    val binding by viewBindings(FragmentGithubUserListBinding::bind)
    val viewModel by viewModels<GithubUserListViewModel>()
}
