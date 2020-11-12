package com.orcchg.direcall.feature.github_repo.fake.di

import com.orcchg.direcall.feature.github_repo.fake.domain.interactor.GithubRepoInteractorFake
import com.orcchg.direcall.feature.githubrepo.api.interactor.GithubRepoInteractor
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module
interface FakeGithubRepoFeatureModule {

    @Binds
    @Reusable
    fun interactor(impl: GithubRepoInteractorFake): GithubRepoInteractor
}
