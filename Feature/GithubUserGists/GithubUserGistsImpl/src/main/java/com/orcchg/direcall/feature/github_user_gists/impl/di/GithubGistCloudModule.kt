package com.orcchg.direcall.feature.github_user_gists.impl.di

import com.orcchg.direcall.feature.github_user_gists.impl.data.remote.GithubGistCloudRest
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.create

@Module
object GithubGistCloudModule {

    @Provides
    fun rest(retrofit: Retrofit): GithubGistCloudRest = retrofit.create()
}
