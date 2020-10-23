package com.orcchg.direcall.feature.github_repo.wiring

import com.orcchg.direcall.feature.github_repo.impl.data.repository.GithubRepoRepository
import com.orcchg.direcall.feature.github_repo.impl.data.repository.GithubRepoRepositoryImpl
import com.orcchg.direcall.feature.github_repo.impl.domain.interactor.GithubRepoInteractorImpl
import com.orcchg.direcall.feature.github_repo.pub.domain.interactor.GithubRepoInteractor
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module(includes = [GithubRepoNetworkModule::class])
interface GithubRepoFeatureModule {

    @Binds
    @Reusable
    fun interactor(impl: GithubRepoInteractorImpl): GithubRepoInteractor

    @Binds
    fun repository(impl: GithubRepoRepositoryImpl): GithubRepoRepository
}
