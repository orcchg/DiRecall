package com.orcchg.direcall.di

import com.orcchg.direcall.data.di.NetworkComponent
import com.orcchg.direcall.ui.GithubUserGistListFragment
import dagger.Component


@Component(dependencies = [NetworkComponent::class], modules = [ViewModelFactoryModule::class])
interface GithubUserGistListFeatureComponent {

    fun inject(userGistFragment: GithubUserGistListFragment)
}