package com.orcchg.direcall.data.di

import com.orcchg.direcall.data.repository.GithubRepositoryImpl
import com.orcchg.direcall.domain.repository.GithubRepository
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module
interface RepositoryModule {

    @Binds
    @Reusable
    fun repository(impl: GithubRepositoryImpl): GithubRepository
}
