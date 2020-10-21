package com.orcchg.direcall.feature.github_user_organizations.impl.di

import com.orcchg.direcall.feature.github_user_organizations.api.interactor.GithubOrganizationInteractor
import com.orcchg.direcall.feature.github_user_organizations.impl.data.repository.GithubOrganizationRepository
import com.orcchg.direcall.feature.github_user_organizations.impl.data.repository.GithubOrganizationRepositoryImpl
import com.orcchg.direcall.feature.github_user_organizations.impl.domain.interactor.GithubOrganizationInteractorImpl
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module(includes = [GithubOrganizationCloudModule::class])
interface GithubOrganizationFeatureModule {

    @Binds
    @Reusable
    fun interactor(impl: GithubOrganizationInteractorImpl): GithubOrganizationInteractor

    @Binds
    fun repository(impl: GithubOrganizationRepositoryImpl): GithubOrganizationRepository
}
