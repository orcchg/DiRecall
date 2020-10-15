package com.orcchg.direcall.github_user_details.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.orcchg.direcall.github_user_details.domain.usecase.GetGithubUserDetailsUseCase

class GithubUserDetailsViewModelFactory(
    private val login: String,
    private val getGithubUserDetailsUseCase: GetGithubUserDetailsUseCase
) : ViewModelProvider.Factory {

    @Suppress("Unchecked_Cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        GithubUserDetailsViewModel(login, getGithubUserDetailsUseCase) as T
}
