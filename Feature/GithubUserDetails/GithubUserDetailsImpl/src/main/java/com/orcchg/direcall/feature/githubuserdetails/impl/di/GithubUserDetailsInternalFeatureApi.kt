package com.orcchg.direcall.feature.githubuserdetails.impl.di

import androidx.lifecycle.ViewModel
import com.orcchg.direcall.feature.githubuserdetails.api.domain.di.GithubUserDetailsFeatureApi

interface GithubUserDetailsInternalFeatureApi : GithubUserDetailsFeatureApi {

    fun viewModel(): ViewModel
}
