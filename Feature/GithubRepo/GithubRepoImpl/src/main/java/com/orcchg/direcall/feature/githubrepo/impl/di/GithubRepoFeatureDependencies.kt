package com.orcchg.direcall.feature.githubrepo.impl.di

import com.orcchg.direcall.core.analytics.api.Analytics
import com.orcchg.direcall.core.scheduler.api.SchedulersFactory
import retrofit2.Retrofit

interface GithubRepoFeatureDependencies {

    fun analytics(): Analytics

    fun retrofit(): Retrofit

    fun schedulersFactory(): SchedulersFactory
}
