package com.orcchg.direcall.github_repo.di

import com.orcchg.direcall.scheduler_api.SchedulersFactory
import retrofit2.Retrofit

interface GithubRepoFeatureDependencies {
    fun retrofit(): Retrofit
    fun schedulersFactory(): SchedulersFactory
}
