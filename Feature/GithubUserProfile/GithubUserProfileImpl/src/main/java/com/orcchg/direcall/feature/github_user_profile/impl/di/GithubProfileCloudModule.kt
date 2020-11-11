package com.orcchg.direcall.feature.github_user_profile.impl.di

import com.orcchg.direcall.feature.github_user_profile.impl.data.remote.GithubProfileCloudRest
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.create

@Module
object GithubProfileCloudModule {

    @Provides
    fun rest(retrofit: Retrofit): GithubProfileCloudRest = retrofit.create()
}
