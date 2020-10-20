package com.orcchg.direcall.github_repo.di

import com.orcchg.direcall.github_repo.data.remote.GithubRepoCloudRest
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Named

@Module
class GithubRepoModule(private val login: String) {

    @Provides
    @Named("login")
    fun login(): String = login

    @Provides
    fun rest(retrofit: Retrofit): GithubRepoCloudRest = retrofit.create()
}
