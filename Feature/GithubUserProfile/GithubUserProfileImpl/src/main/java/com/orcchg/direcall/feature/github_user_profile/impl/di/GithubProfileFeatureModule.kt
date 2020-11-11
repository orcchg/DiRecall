package com.orcchg.direcall.feature.github_user_profile.impl.di

import com.orcchg.direcall.feature.github_user_profile.api.interactor.GithubProfileInteractor
import com.orcchg.direcall.feature.github_user_profile.impl.data.repository.GithubProfileRepository
import com.orcchg.direcall.feature.github_user_profile.impl.data.repository.GithubProfileRepositoryImpl
import com.orcchg.direcall.feature.github_user_profile.impl.domain.interactor.GithubProfileInteractorImpl
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module(includes = [GithubProfileCloudModule::class])
interface GithubProfileFeatureModule {

    @Binds
    @Reusable
    fun interactor(impl: GithubProfileInteractorImpl): GithubProfileInteractor

    @Binds
    fun repository(impl: GithubProfileRepositoryImpl): GithubProfileRepository
}
