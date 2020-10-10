package com.orcchg.direcall.feature.githubuserdetails.impl.di

import com.orcchg.direcall.feature.githubuserdetails.api.domain.interactor.GithubUserDetailsInteractor
import com.orcchg.direcall.feature.githubuserdetails.impl.data.repository.GithubUserDetailsRepository
import com.orcchg.direcall.feature.githubuserdetails.impl.data.repository.GithubUserDetailsRepositoryImpl
import com.orcchg.direcall.feature.githubuserdetails.impl.domain.interactor.GithubUserDetailsInteractorImpl
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module(includes = [GithubUserDetailsCloudModule::class])
interface GithubUserDetailsFeatureModule {

    @Binds
    @Reusable
    fun interactor(impl: GithubUserDetailsInteractorImpl): GithubUserDetailsInteractor

    @Binds
    fun repository(impl: GithubUserDetailsRepositoryImpl): GithubUserDetailsRepository
}
