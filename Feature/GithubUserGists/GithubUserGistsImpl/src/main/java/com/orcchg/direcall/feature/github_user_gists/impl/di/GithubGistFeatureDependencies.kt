package com.orcchg.direcall.feature.github_user_gists.impl.di

import com.orcchg.direcall.base.SchedulersFactory
import retrofit2.Retrofit

interface GithubGistFeatureDependencies {

    fun retrofit(): Retrofit

    fun schedulersFactory(): SchedulersFactory
}
