package com.orcchg.direcall.di

import com.orcchg.direcall.data.di.NetworkComponent
import com.orcchg.direcall.ui.GithubUserGistListFragment
import dagger.Component


@Component(dependencies = [NetworkComponent::class], modules = [RepoModule::class, UseCaseModule::class])
interface GithubUserGistListFeatureComponent {

    fun inject(userGistFragment: GithubUserGistListFragment)
}