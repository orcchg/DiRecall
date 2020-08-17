package com.orcchg.direcall.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.orcchg.direcall.viewmodel.GithubUserDetailsViewModel

class GithubUserDetailsFragment : Fragment() {

    val viewModel by viewModels<GithubUserDetailsViewModel>()
}
