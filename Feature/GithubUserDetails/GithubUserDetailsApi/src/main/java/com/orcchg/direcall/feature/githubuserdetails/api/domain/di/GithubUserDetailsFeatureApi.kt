package com.orcchg.direcall.feature.githubuserdetails.api.domain.di

import com.orcchg.direcall.feature.githubuserdetails.api.domain.interactor.GithubUserDetailsInteractor

interface GithubUserDetailsFeatureApi {

    fun interactor(): GithubUserDetailsInteractor
}
