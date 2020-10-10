package com.orcchg.direcall.feature.githubuserlist.impl.di

import com.orcchg.direcall.feature.githubuserlist.impl.data.remote.GithubUserListCloudRest
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.create

@Module
object GithubUserListCloudModule {

    @Provides
    fun rest(retrofit: Retrofit): GithubUserListCloudRest = retrofit.create()
}
