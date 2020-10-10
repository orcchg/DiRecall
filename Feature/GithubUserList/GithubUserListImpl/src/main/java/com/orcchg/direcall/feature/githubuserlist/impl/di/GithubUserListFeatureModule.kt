package com.orcchg.direcall.feature.githubuserlist.impl.di

import com.orcchg.direcall.feature.githubuserlist.api.domain.interactor.GithubUserListInteractor
import com.orcchg.direcall.feature.githubuserlist.impl.data.repository.GithubUserListRepository
import com.orcchg.direcall.feature.githubuserlist.impl.data.repository.GithubUserListRepositoryImpl
import com.orcchg.direcall.feature.githubuserlist.impl.domain.interactor.GithubUserListInteractorImpl
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module(includes = [GithubUserListCloudModule::class])
interface GithubUserListFeatureModule {

    @Binds
    @Reusable
    fun interactor(impl: GithubUserListInteractorImpl): GithubUserListInteractor

    @Binds
    fun repository(impl: GithubUserListRepositoryImpl): GithubUserListRepository
}
