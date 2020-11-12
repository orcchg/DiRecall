package com.orcchg.direcall.feature.github_user_followers.fake.di

import com.orcchg.direcall.feature.github_user_followers.api.interactor.GithubFollowerInteractor
import com.orcchg.direcall.feature.github_user_followers.fake.domain.interactor.GithubFollowerInteractorFake
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module
interface FakeGithubFollowerFeatureModule {

    @Binds
    @Reusable
    fun interactor(impl: GithubFollowerInteractorFake): GithubFollowerInteractor
}
