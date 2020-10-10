package com.orcchg.direcall.feature.githubuserlist.impl.di

import com.orcchg.direcall.core.scheduler.api.SchedulersFactory
import retrofit2.Retrofit

interface GithubUserListFeatureDependencies {

    fun retrofit(): Retrofit

    fun schedulersFactory(): SchedulersFactory
}
