package com.orcchg.direcall.di

import com.orcchg.direcall.data.di.NetworkComponent
import com.orcchg.direcall.ui.GithubUserFollowersFragment
import dagger.Component


@Component(dependencies = [NetworkComponent::class], modules = [RepoModule::class, UseCaseModule::class])
interface GithubUserFollowersFeatureComponent{

    fun inject(userFollowersFragment: GithubUserFollowersFragment)
}