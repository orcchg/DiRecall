package com.orcchg.direcall.github_user_list.di

import com.orcchg.direcall.scheduler_api.SchedulersFactory
import retrofit2.Retrofit

interface GithubUserListFeatureDependencies {
    fun retrofit(): Retrofit
    fun schedulersFactory(): SchedulersFactory
}
