package com.orcchg.direcall.feature.githubuserdetails.impl.di

import com.orcchg.direcall.feature.githubuserdetails.impl.data.remote.GithubUserDetailsCloudRest
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.create

@Module
object GithubUserDetailsCloudModule {

    @Provides
    fun rest(retrofit: Retrofit): GithubUserDetailsCloudRest = retrofit.create()
}
