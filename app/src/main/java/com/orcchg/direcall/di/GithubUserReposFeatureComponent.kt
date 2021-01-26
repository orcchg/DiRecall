package com.orcchg.direcall.di

import com.orcchg.direcall.data.di.NetworkComponent
import com.orcchg.direcall.ui.GithubUserReposFragment
import dagger.Component


@Component(dependencies = [NetworkComponent::class], modules = [ViewModelFactoryModule::class])
interface GithubUserReposFeatureComponent {

    fun inject(userReposFragment: GithubUserReposFragment)
}