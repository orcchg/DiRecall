package com.orcchg.direcall.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.orcchg.direcall.domain.usecase.GetGithubUserOrgsUseCase

class GithubUserOrgsListViewModelFactory(
    private val login: String,
    private val useCase: GetGithubUserOrgsUseCase
) : ViewModelProvider.Factory {

    @Suppress("Unchecked_Cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        GithubUserOrgsListViewModel(login, useCase) as T
}