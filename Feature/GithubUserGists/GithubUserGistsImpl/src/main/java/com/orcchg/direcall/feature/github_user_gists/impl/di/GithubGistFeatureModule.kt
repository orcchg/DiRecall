package com.orcchg.direcall.feature.github_user_gists.impl.di

import com.orcchg.direcall.feature.github_user_gists.api.interactor.GithubGistInteractor
import com.orcchg.direcall.feature.github_user_gists.impl.data.repository.GithubGistRepository
import com.orcchg.direcall.feature.github_user_gists.impl.data.repository.GithubGistRepositoryImpl
import com.orcchg.direcall.feature.github_user_gists.impl.domain.interactor.GithubGistInteractorImpl
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module(includes = [GithubGistCloudModule::class])
interface GithubGistFeatureModule {

    @Binds
    @Reusable
    fun interactor(impl: GithubGistInteractorImpl): GithubGistInteractor

    @Binds
    fun repository(impl: GithubGistRepositoryImpl): GithubGistRepository
}
