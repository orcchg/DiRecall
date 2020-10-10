package com.orcchg.direcall.feature.githubrepo.impl.di

import com.orcchg.direcall.feature.githubrepo.api.interactor.GithubRepoInteractor
import com.orcchg.direcall.feature.githubrepo.impl.data.repository.GithubRepoRepository
import com.orcchg.direcall.feature.githubrepo.impl.data.repository.GithubRepoRepositoryImpl
import com.orcchg.direcall.feature.githubrepo.impl.domain.interactor.GithubRepoInteractorImpl
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module(includes = [GithubRepoCloudModule::class])
interface GithubRepoFeatureModule {

    @Binds
    @Reusable
    fun interactor(impl: GithubRepoInteractorImpl): GithubRepoInteractor

    @Binds
    fun repository(impl: GithubRepoRepositoryImpl): GithubRepoRepository
}
