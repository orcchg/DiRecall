package com.orcchg.direcall.github_repo.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

class GithubRepoViewModelFactory @Inject constructor(
    private val provider: Provider<GithubRepoViewModel>
) : ViewModelProvider.Factory {

    @Suppress("Unchecked_Cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T = provider.get() as T
}
