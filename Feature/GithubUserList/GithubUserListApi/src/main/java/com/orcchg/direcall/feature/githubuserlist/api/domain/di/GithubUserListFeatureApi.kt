package com.orcchg.direcall.feature.githubuserlist.api.domain.di

import com.orcchg.direcall.feature.githubuserlist.api.domain.interactor.GithubUserListInteractor

interface GithubUserListFeatureApi {

    fun interactor(): GithubUserListInteractor
}
