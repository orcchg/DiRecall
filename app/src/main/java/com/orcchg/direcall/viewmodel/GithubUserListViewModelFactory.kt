package com.orcchg.direcall.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.orcchg.direcall.domain.usecase.GetGithubUsersUseCase

class GithubUserListViewModelFactory(private val useCase: GetGithubUsersUseCase) : ViewModelProvider.Factory {

    @Suppress("Unchecked_Cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        GithubUserListViewModel(useCase) as T
}