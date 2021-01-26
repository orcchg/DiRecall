package com.orcchg.direcall.di

import com.orcchg.direcall.data.di.NetworkComponent
import com.orcchg.direcall.ui.GithubUserOrgsFragment
import dagger.Component


@Component(dependencies = [NetworkComponent::class], modules = [ViewModelFactoryModule::class])
interface GithubUserOrgsFeatureComponent {

    @Component.Factory
    interface Factory {
        fun create(
            networkComponent: NetworkComponent,
            viewModelFactoryModule: ViewModelFactoryModule
        ): GithubUserOrgsFeatureComponent
    }

    fun inject(userOrgsFragment: GithubUserOrgsFragment)
}