package com.orcchg.direcall.feature.github_user_details.wiring

import com.orcchg.direcall.feature.github_user_details.impl.data.repository.GithubUserDetailsRepository
import com.orcchg.direcall.feature.github_user_details.impl.data.repository.GithubUserDetailsRepositoryImpl
import com.orcchg.direcall.feature.github_user_details.impl.domain.interactor.GithubUserDetailsInteractorImpl
import com.orcchg.direcall.feature.github_user_details.pub.domain.interactor.GithubUserDetailsInteractor
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module(includes = [GithubUserDetailsNetworkModule::class])
interface GithubUserDetailsFeatureModule {

    @Binds
    @Reusable
    fun interactor(impl: GithubUserDetailsInteractorImpl): GithubUserDetailsInteractor

    @Binds
    fun repository(impl: GithubUserDetailsRepositoryImpl): GithubUserDetailsRepository
}
