package com.orcchg.direcall.feature.githubrepo.impl.di

import androidx.lifecycle.ViewModel
import com.orcchg.direcall.feature.githubrepo.api.di.GithubRepoFeatureApi

interface GithubRepoInternalFeatureApi : GithubRepoFeatureApi {

    fun viewModel(): ViewModel
}