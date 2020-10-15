package com.orcchg.direcall.github_repo.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.orcchg.direcall.github_repo.domain.usecase.GetGithubReposUseCase

class GithubRepoViewModelFactory(
    private val login: String,
    private val getGithubReposUseCase: GetGithubReposUseCase
) : ViewModelProvider.Factory {

    @Suppress("Unchecked_Cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        GithubRepoViewModel(login, getGithubReposUseCase) as T
}
