package com.orcchg.direcall.di

import com.orcchg.direcall.data.di.NetworkComponent
import com.orcchg.direcall.ui.GithubUserFollowersFragment
import dagger.Component


@Component(dependencies = [NetworkComponent::class], modules = [ViewModelFactoryModule::class])
interface GithubUserFollowersFeatureComponent {

    @Component.Factory
    interface Factory {
        fun create(
            networkComponent: NetworkComponent,
            viewModelFactoryModule: ViewModelFactoryModule
        ): GithubUserFollowersFeatureComponent
    }

    fun inject(userFollowersFragment: GithubUserFollowersFragment)
}