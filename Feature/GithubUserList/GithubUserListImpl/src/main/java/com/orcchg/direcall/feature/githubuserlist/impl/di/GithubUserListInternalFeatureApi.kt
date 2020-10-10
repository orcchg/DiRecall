package com.orcchg.direcall.feature.githubuserlist.impl.di

import androidx.lifecycle.ViewModel
import com.orcchg.direcall.feature.githubuserlist.api.domain.di.GithubUserListFeatureApi

interface GithubUserListInternalFeatureApi : GithubUserListFeatureApi {

    fun viewModel(): ViewModel
}
