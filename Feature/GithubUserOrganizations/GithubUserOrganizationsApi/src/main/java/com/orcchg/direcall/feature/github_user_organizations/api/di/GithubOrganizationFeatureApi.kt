package com.orcchg.direcall.feature.github_user_organizations.api.di

import com.orcchg.direcall.feature.github_user_organizations.api.interactor.GithubOrganizationInteractor

interface GithubOrganizationFeatureApi {

    fun interactor(): GithubOrganizationInteractor
}
