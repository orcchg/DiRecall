package com.orcchg.direcall.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.orcchg.direcall.App

class GithubUserFollowersListModelFactory(
    private val login: String,
    private val app: App
) : ViewModelProvider.Factory {

    @Suppress("Unchecked_Cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        GithubUserFollowersListViewModel(login, app) as T
}