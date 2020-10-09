package com.orcchg.direcall.data.di

import com.orcchg.direcall.data.remote.GithubRepoCloudRest
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.create

@Module
object RepoCloudModule {

    @Provides
    fun repoCloud(retrofit: Retrofit): GithubRepoCloudRest =
        retrofit.create()
}
