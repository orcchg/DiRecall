package com.orcchg.direcall.github_repo.di

import com.orcchg.direcall.github_repo.presentation.viewmodel.GithubRepoViewModel

interface GithubRepoBindingsProvider {

    val githubRepoViewModelAssistedFactory: GithubRepoViewModel.RealAssistedFactory
}
