package com.orcchg.direcall.di

import com.orcchg.direcall.data.di.NetworkComponent
import com.orcchg.direcall.ui.GithubUserDetailsFragment
import dagger.Component


@Component(dependencies = [NetworkComponent::class], modules = [ViewModelFactoryModule::class])
interface GithubUserDetailsFeatureComponent {

    @Component.Factory
    interface Factory{
        fun create(
            networkComponent: NetworkComponent, viewModelFactoryModule: ViewModelFactoryModule
        ): GithubUserDetailsFeatureComponent
    }

    fun inject(userDetailsFragment: GithubUserDetailsFragment)
}