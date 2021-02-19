package com.orcchg.direcall.github_user_details.di

import com.orcchg.direcall.scheduler_api.SchedulersFactory
import retrofit2.Retrofit

interface GithubUserDetailsFeatureDependencies {
    fun retrofit(): Retrofit
    fun schedulersFactory(): SchedulersFactory
}
