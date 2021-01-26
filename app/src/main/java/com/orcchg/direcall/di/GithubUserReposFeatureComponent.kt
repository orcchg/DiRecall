package com.orcchg.direcall.di

import com.orcchg.direcall.data.di.NetworkComponent
import com.orcchg.direcall.ui.GithubUserReposFragment
import dagger.Component


@Component(dependencies = [NetworkComponent::class], modules = [ViewModelFactoryModule::class])
interface GithubUserReposFeatureComponent {

    @Component.Factory
    interface Factory {
        fun create(
            networkComponent: NetworkComponent,
            viewModelFactoryModule: ViewModelFactoryModule
        ): GithubUserReposFeatureComponent
    }

    fun inject(userReposFragment: GithubUserReposFragment)
}