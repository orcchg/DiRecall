package com.orcchg.direcall.feature.github_user_profile.dfm.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

class GithubUserProfileViewModelFactory @Inject constructor(
    private val provider: Provider<GithubUserProfileViewModel>
) : ViewModelProvider.Factory {

    @Suppress("Unchecked_Cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        provider.get() as T
}
