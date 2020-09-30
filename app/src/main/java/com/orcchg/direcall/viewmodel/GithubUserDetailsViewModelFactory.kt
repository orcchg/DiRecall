package com.orcchg.direcall.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.orcchg.direcall.domain.usecase.GetGithubUserDetailsUseCase

class GithubUserDetailsViewModelFactory(
    private val login: String,
    private val getGithubUserDetailsUseCase: GetGithubUserDetailsUseCase
) : ViewModelProvider.Factory {

    @Suppress("Unchecked_Cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        GithubUserDetailsViewModel(login, getGithubUserDetailsUseCase) as T
}

