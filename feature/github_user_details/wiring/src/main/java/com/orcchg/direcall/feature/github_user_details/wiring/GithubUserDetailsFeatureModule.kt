package com.orcchg.direcall.feature.github_user_details.wiring

import com.orcchg.direcall.feature.github_user_details.impl.data.repository.GithubUserDetailsRepository
import com.orcchg.direcall.feature.github_user_details.impl.data.repository.GithubUserDetailsRepositoryImpl
import com.orcchg.direcall.feature.github_user_details.impl.domain.interactor.GithubUserDetailsInteractorImpl
import com.orcchg.direcall.feature.github_user_details.pub.GithubUserDetailsFeatureScope
import com.orcchg.direcall.feature.github_user_details.pub.domain.interactor.GithubUserDetailsInteractor
import com.squareup.anvil.annotations.ContributesTo
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module
@ContributesTo(GithubUserDetailsFeatureScope::class)
interface GithubUserDetailsFeatureModule {

    @Binds
    @Reusable
    fun interactor(impl: GithubUserDetailsInteractorImpl): GithubUserDetailsInteractor

    @Binds
    fun repository(impl: GithubUserDetailsRepositoryImpl): GithubUserDetailsRepository
}
