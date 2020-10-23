package com.orcchg.direcall.feature.github_user_list.wiring

import com.orcchg.direcall.feature.github_user_list.impl.data.repository.GithubUserListRepository
import com.orcchg.direcall.feature.github_user_list.impl.data.repository.GithubUserListRepositoryImpl
import com.orcchg.direcall.feature.github_user_list.pub.domain.interactor.GithubUserListInteractor
import com.orcchg.direcall.feature.github_user_list.impl.domain.interactor.GithubUserListInteractorImpl
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module(includes = [GithubUserListNetworkModule::class])
interface GithubUserListFeatureModule {

    @Binds
    @Reusable
    fun interactor(impl: GithubUserListInteractorImpl): GithubUserListInteractor

    @Binds
    fun repository(impl: GithubUserListRepositoryImpl): GithubUserListRepository
}
