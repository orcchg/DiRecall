package com.orcchg.direcall.feature.github_user_gists.fake.di

import com.orcchg.direcall.feature.github_user_gists.api.interactor.GithubGistInteractor
import com.orcchg.direcall.feature.github_user_gists.fake.domain.interactor.GithubGistInteractorFake
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module
interface FakeGithubGistFeatureModule {

    @Binds
    @Reusable
    fun interactor(impl: GithubGistInteractorFake): GithubGistInteractor
}
