package com.orcchg.direcall.feature.github_user_organizations.fake.di

import com.orcchg.direcall.feature.github_user_organizations.api.interactor.GithubOrganizationInteractor
import com.orcchg.direcall.feature.github_user_organizations.fake.domain.interactor.GithubOrganizationInteractorFake
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module
interface FakeGithubOrganizationFeatureModule {

    @Binds
    @Reusable
    fun interactor(impl: GithubOrganizationInteractorFake): GithubOrganizationInteractor
}
