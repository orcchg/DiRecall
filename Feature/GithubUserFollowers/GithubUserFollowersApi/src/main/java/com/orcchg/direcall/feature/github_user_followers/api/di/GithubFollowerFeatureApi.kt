package com.orcchg.direcall.feature.github_user_followers.api.di

import com.orcchg.direcall.feature.github_user_followers.api.interactor.GithubFollowerInteractor

interface GithubFollowerFeatureApi {

    fun interactor(): GithubFollowerInteractor
}
