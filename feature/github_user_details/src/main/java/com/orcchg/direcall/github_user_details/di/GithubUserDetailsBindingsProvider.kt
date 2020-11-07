package com.orcchg.direcall.github_user_details.di

import com.orcchg.direcall.github_user_details.presentation.viewmodel.GithubUserDetailsViewModel

interface GithubUserDetailsBindingsProvider {

    val githubUserDetailsViewModelAssistedFactory: GithubUserDetailsViewModel.RealAssistedFactory
}
