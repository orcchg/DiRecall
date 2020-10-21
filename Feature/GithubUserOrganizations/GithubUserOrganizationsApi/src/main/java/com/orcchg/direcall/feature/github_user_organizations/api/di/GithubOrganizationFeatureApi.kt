package com.orcchg.direcall.feature.github_user_organizations.api.di

import com.orcchg.direcall.feature.github_user_organizations.api.interactor.GithubOrganizationInteractor
import javax.inject.Named

interface GithubOrganizationFeatureApi {

    fun interactor(): GithubOrganizationInteractor

    @Named("login") fun login(): String
}
