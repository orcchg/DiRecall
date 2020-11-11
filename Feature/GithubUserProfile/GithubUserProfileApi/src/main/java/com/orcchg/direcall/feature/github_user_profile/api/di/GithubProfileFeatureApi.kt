package com.orcchg.direcall.feature.github_user_profile.api.di

import com.orcchg.direcall.feature.github_user_profile.api.interactor.GithubProfileInteractor

interface GithubProfileFeatureApi {

    fun interactor(): GithubProfileInteractor
}
