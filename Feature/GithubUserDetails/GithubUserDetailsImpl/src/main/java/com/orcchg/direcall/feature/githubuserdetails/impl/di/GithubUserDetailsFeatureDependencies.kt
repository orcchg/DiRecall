package com.orcchg.direcall.feature.githubuserdetails.impl.di

import com.orcchg.direcall.core.scheduler.api.SchedulersFactory
import retrofit2.Retrofit

interface GithubUserDetailsFeatureDependencies {

    fun retrofit(): Retrofit

    fun schedulersFactory(): SchedulersFactory
}
