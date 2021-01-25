package com.orcchg.direcall.di

import com.orcchg.direcall.data.di.NetworkComponent
import com.orcchg.direcall.ui.GithubUserListFragment
import dagger.Component


@Component(dependencies = [NetworkComponent::class], modules = [RepoModule::class, UseCaseModule::class])
interface GithubUsersFeatureComponent {

    fun inject(usersListFragment: GithubUserListFragment)
}