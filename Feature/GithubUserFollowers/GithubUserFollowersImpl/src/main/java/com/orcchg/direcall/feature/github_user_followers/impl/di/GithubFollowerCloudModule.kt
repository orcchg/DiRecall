package com.orcchg.direcall.feature.github_user_followers.impl.di

import com.orcchg.direcall.feature.github_user_followers.impl.data.remote.GithubFollowerCloudRest
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.create

@Module
object GithubFollowerCloudModule {

    @Provides
    fun rest(retrofit: Retrofit): GithubFollowerCloudRest = retrofit.create()
}
