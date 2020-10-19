package com.orcchg.direcall.di

import com.orcchg.direcall.github_repo.data.remote.GithubRepoCloudRest
import com.orcchg.direcall.github_user_details.data.remote.GithubUserDetailsCloudRest
import com.orcchg.direcall.github_user_list.data.remote.GithubUserListCloudRest
import com.orcchg.direcall.network.CloudModule
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.create

@Module(includes = [CloudModule::class])
@InstallIn(ApplicationComponent::class)
object NetworkModule {

    @Provides
    fun githubRepoCloudRest(retrofit: Retrofit): GithubRepoCloudRest =
        retrofit.create()

    @Provides
    fun githubUserDetailsCloudRest(retrofit: Retrofit): GithubUserDetailsCloudRest =
        retrofit.create()

    @Provides
    fun githubUserListCloudRest(retrofit: Retrofit): GithubUserListCloudRest =
        retrofit.create()
}
