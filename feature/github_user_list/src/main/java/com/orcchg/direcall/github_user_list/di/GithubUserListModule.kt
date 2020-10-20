package com.orcchg.direcall.github_user_list.di

import com.orcchg.direcall.github_user_list.data.remote.GithubUserListCloudRest
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.create

@Module
object GithubUserListModule {

    @Provides
    fun rest(retrofit: Retrofit): GithubUserListCloudRest = retrofit.create()
}
