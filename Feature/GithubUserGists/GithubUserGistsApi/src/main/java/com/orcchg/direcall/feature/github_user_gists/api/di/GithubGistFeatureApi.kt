package com.orcchg.direcall.feature.github_user_gists.api.di

import com.orcchg.direcall.feature.github_user_gists.api.interactor.GithubGistInteractor

interface GithubGistFeatureApi {

    fun interactor(): GithubGistInteractor
}
