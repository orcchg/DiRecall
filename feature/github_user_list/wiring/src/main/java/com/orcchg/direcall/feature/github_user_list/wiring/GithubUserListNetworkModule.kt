package com.orcchg.direcall.feature.github_user_list.wiring

import com.orcchg.direcall.feature.github_user_list.impl.data.remote.GithubUserCloudRest
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.create

@Module
object GithubUserListNetworkModule {

    @Provides
    fun rest(retrofit: Retrofit): GithubUserCloudRest = retrofit.create()
}
