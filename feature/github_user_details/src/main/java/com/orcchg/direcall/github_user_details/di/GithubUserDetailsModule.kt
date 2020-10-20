package com.orcchg.direcall.github_user_details.di

import com.orcchg.direcall.github_user_details.data.remote.GithubUserDetailsCloudRest
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Named

@Module
class GithubUserDetailsModule(private val login: String) {

    @Provides
    @Named("login")
    fun login(): String = login

    @Provides
    fun rest(retrofit: Retrofit): GithubUserDetailsCloudRest = retrofit.create()
}
