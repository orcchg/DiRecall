package com.orcchg.direcall.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.orcchg.direcall.domain.usecase.GetGithubUserRepoUseCase

class GithubUserReposViewModelFactory(
    private val login: String,
    private val getGithubUserRepoUseCase: GetGithubUserRepoUseCase
) : ViewModelProvider.Factory {

    @Suppress("Unchecked_Cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        GithubUserReposViewModel(login, getGithubUserRepoUseCase) as T
}