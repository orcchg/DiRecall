package com.orcchg.direcall.data.di

import com.orcchg.direcall.data.repository.GithubRepositoryImpl
import com.orcchg.direcall.domain.repository.GithubRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module(
    includes = [
        CloudModule::class,
        RepoCloudModule::class,
        UserCloudModule::class
    ]
)
@InstallIn(ApplicationComponent::class)
interface DataModule {

    @Binds
    @Singleton
    fun githubRepository(impl: GithubRepositoryImpl): GithubRepository
}
