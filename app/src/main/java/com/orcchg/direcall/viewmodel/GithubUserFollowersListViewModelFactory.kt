package com.orcchg.direcall.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.orcchg.direcall.domain.usecase.GetGithubUserFollowersUseCase

class GithubUserFollowersListViewModelFactory(
    private val login: String,
    private val getGithubUserFollowersUseCase: GetGithubUserFollowersUseCase
) : ViewModelProvider.Factory {

    @Suppress("Unchecked_Cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        GithubUserFollowersListViewModel(login, getGithubUserFollowersUseCase) as T
}