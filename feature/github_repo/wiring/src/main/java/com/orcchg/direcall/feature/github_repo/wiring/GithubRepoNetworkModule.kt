package com.orcchg.direcall.feature.github_repo.wiring

import com.orcchg.direcall.feature.github_repo.impl.data.remote.GithubRepoCloudRest
import com.orcchg.direcall.feature.github_repo.pub.GithubRepoFeatureScope
import com.squareup.anvil.annotations.ContributesTo
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.create

@Module
@ContributesTo(GithubRepoFeatureScope::class)
object GithubRepoNetworkModule {

    @Provides
    fun rest(retrofit: Retrofit): GithubRepoCloudRest = retrofit.create()
}
