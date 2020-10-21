package com.orcchg.direcall.feature.github_user_organizations.impl.di

import com.orcchg.direcall.feature.github_user_organizations.impl.data.remote.GithubOrganizationCloudRest
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.create

@Module
object GithubOrganizationCloudModule {

    @Provides
    fun rest(retrofit: Retrofit): GithubOrganizationCloudRest = retrofit.create()
}
