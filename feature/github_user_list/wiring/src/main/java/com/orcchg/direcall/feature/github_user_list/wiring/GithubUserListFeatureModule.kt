package com.orcchg.direcall.feature.github_user_list.wiring

import com.orcchg.direcall.feature.github_user_list.impl.data.repository.GithubUserListRepository
import com.orcchg.direcall.feature.github_user_list.impl.data.repository.GithubUserListRepositoryImpl
import com.orcchg.direcall.feature.github_user_list.impl.domain.interactor.GithubUserListInteractorImpl
import com.orcchg.direcall.feature.github_user_list.pub.GithubUserListFeatureScope
import com.orcchg.direcall.feature.github_user_list.pub.domain.interactor.GithubUserListInteractor
import com.squareup.anvil.annotations.ContributesTo
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module
@ContributesTo(GithubUserListFeatureScope::class)
interface GithubUserListFeatureModule {

    @Binds
    @Reusable
    fun interactor(impl: GithubUserListInteractorImpl): GithubUserListInteractor

    @Binds
    fun repository(impl: GithubUserListRepositoryImpl): GithubUserListRepository
}
