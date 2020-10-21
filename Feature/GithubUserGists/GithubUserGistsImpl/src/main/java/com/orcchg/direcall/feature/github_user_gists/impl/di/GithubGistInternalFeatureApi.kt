package com.orcchg.direcall.feature.github_user_gists.impl.di

import androidx.lifecycle.ViewModel
import com.orcchg.direcall.feature.github_user_gists.api.di.GithubGistFeatureApi

interface GithubGistInternalFeatureApi : GithubGistFeatureApi {

    fun viewModel(): ViewModel
}
