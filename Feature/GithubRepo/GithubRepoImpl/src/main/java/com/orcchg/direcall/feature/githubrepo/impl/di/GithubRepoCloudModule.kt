package com.orcchg.direcall.feature.githubrepo.impl.di

import com.orcchg.direcall.feature.githubrepo.impl.data.remote.GithubRepoCloudRest
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.create

@Module
object GithubRepoCloudModule {

    @Provides
    fun rest(retrofit: Retrofit): GithubRepoCloudRest = retrofit.create()
}
