package com.orcchg.direcall.feature.github_repo.wiring

import com.orcchg.direcall.feature.github_repo.impl.data.repository.GithubRepoRepository
import com.orcchg.direcall.feature.github_repo.impl.data.repository.GithubRepoRepositoryImpl
import com.orcchg.direcall.feature.github_repo.impl.domain.interactor.GithubRepoInteractorImpl
import com.orcchg.direcall.feature.github_repo.pub.GithubRepoFeatureScope
import com.orcchg.direcall.feature.github_repo.pub.domain.interactor.GithubRepoInteractor
import com.squareup.anvil.annotations.ContributesTo
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module
@ContributesTo(GithubRepoFeatureScope::class)
interface GithubRepoFeatureModule {

    @Binds
    @Reusable
    fun interactor(impl: GithubRepoInteractorImpl): GithubRepoInteractor

    @Binds
    fun repository(impl: GithubRepoRepositoryImpl): GithubRepoRepository
}
