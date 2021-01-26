package com.orcchg.direcall.di

import com.orcchg.direcall.data.di.NetworkComponent
import com.orcchg.direcall.ui.GithubUserListFragment
import dagger.Component


@Component(dependencies = [NetworkComponent::class], modules = [ViewModelFactoryModule::class])
interface GithubUsersFeatureComponent {

    @Component.Factory
    interface Factory {
        fun create(
            networkComponent: NetworkComponent,
            viewModelFactoryModule: ViewModelFactoryModule
        ): GithubUsersFeatureComponent
    }

    fun inject(usersListFragment: GithubUserListFragment)
}