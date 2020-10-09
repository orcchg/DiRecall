package com.orcchg.direcall.data.di

import com.orcchg.direcall.data.remote.GithubUserCloudRest
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.create

@Module
object UserCloudModule {

    @Provides
    fun userCloud(retrofit: Retrofit): GithubUserCloudRest =
        retrofit.create()
}
