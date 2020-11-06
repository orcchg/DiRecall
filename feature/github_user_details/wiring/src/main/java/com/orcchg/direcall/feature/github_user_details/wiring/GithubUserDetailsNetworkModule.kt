package com.orcchg.direcall.feature.github_user_details.wiring

import com.orcchg.direcall.feature.github_user_details.impl.data.remote.GithubUserDetailsCloudRest
import com.orcchg.direcall.feature.github_user_details.pub.GithubUserDetailsFeatureScope
import com.squareup.anvil.annotations.ContributesTo
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.create

@Module
@ContributesTo(GithubUserDetailsFeatureScope::class)
object GithubUserDetailsNetworkModule {

    @Provides
    fun rest(retrofit: Retrofit): GithubUserDetailsCloudRest = retrofit.create()
}
