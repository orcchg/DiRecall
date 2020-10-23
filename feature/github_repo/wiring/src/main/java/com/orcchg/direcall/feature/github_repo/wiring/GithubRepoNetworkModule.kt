package com.orcchg.direcall.feature.github_repo.wiring

import com.orcchg.direcall.feature.github_repo.impl.data.remote.GithubRepoCloudRest
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.create

@Module
object GithubRepoNetworkModule {

    @Provides
    fun rest(retrofit: Retrofit): GithubRepoCloudRest = retrofit.create()
}
