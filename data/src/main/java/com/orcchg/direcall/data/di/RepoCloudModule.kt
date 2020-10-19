package com.orcchg.direcall.data.di

import com.orcchg.direcall.data.remote.GithubRepoCloudRest
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.create

@Module
@InstallIn(ApplicationComponent::class)
object RepoCloudModule {

    @Provides
    fun repoCloud(retrofit: Retrofit): GithubRepoCloudRest =
        retrofit.create()
}
