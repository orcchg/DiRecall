package com.orcchg.direcall.feature.githubrepo.api.di

import com.orcchg.direcall.feature.githubrepo.api.interactor.GithubRepoInteractor

interface GithubRepoFeatureApi {

    fun interactor(): GithubRepoInteractor
}
