package com.orcchg.direcall.feature.github_user_organizations.impl.di

import com.orcchg.direcall.core.analytics.api.Analytics
import com.orcchg.direcall.core.scheduler.api.SchedulersFactory
import retrofit2.Retrofit

interface GithubOrganizationFeatureDependencies {

    fun analytics(): Analytics

    fun retrofit(): Retrofit

    fun schedulersFactory(): SchedulersFactory
}
