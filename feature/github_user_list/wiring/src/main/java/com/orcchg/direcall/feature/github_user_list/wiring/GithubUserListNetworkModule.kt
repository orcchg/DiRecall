package com.orcchg.direcall.feature.github_user_list.wiring

import com.orcchg.direcall.feature.github_user_list.impl.data.remote.GithubUserCloudRest
import com.orcchg.direcall.feature.github_user_list.pub.GithubUserListFeatureScope
import com.squareup.anvil.annotations.ContributesTo
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.create

@Module
@ContributesTo(GithubUserListFeatureScope::class)
object GithubUserListNetworkModule {

    @Provides
    fun rest(retrofit: Retrofit): GithubUserCloudRest = retrofit.create()
}
