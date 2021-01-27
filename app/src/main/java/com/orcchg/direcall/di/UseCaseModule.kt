package com.orcchg.direcall.di

import com.orcchg.direcall.androidutil.SchedulersFactoryImpl
import com.orcchg.direcall.base.SchedulersFactory
import com.orcchg.direcall.data.repository.GithubRepositoryImpl
import com.orcchg.direcall.domain.repository.GithubRepository
import dagger.Binds
import dagger.Module

@Module
interface UseCaseModule {
    @Binds
    fun getRepo(repository: GithubRepositoryImpl): GithubRepository

    @Binds
    fun getScheduler(scheduler: SchedulersFactoryImpl): SchedulersFactory
}