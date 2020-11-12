package com.orcchg.direcall.feature.github_user_details.fake.di

import com.orcchg.direcall.feature.github_user_details.fake.domain.interactor.GithubUserDetailsInteractorFake
import com.orcchg.direcall.feature.githubuserdetails.api.domain.interactor.GithubUserDetailsInteractor
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module
interface FakeGithubUserDetailsFeatureModule {

    @Binds
    @Reusable
    fun interactor(impl: GithubUserDetailsInteractorFake): GithubUserDetailsInteractor
}
