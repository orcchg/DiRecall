package com.orcchg.direcall.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.orcchg.direcall.domain.usecase.GetGithubUserGistUseCase

class GithubUserGistListViewModelFactory(
    private val login: String,
    private val useCase: GetGithubUserGistUseCase
) : ViewModelProvider.Factory {

    @Suppress("Unchecked_Cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        GithubUserGistListViewModel(login, useCase) as T
}