package com.orcchg.direcall.feature.github_user_followers.impl.di

import com.orcchg.direcall.feature.github_user_followers.api.interactor.GithubFollowerInteractor
import com.orcchg.direcall.feature.github_user_followers.impl.data.repository.GithubFollowerRepository
import com.orcchg.direcall.feature.github_user_followers.impl.data.repository.GithubFollowerRepositoryImpl
import com.orcchg.direcall.feature.github_user_followers.impl.domain.interactor.GithubFollowerInteractorImpl
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module(includes = [GithubFollowerCloudModule::class])
interface GithubFollowerFeatureModule {

    @Binds
    @Reusable
    fun interactor(impl: GithubFollowerInteractorImpl): GithubFollowerInteractor

    @Binds
    fun repository(impl: GithubFollowerRepositoryImpl): GithubFollowerRepository
}
