package com.orcchg.direcall.di

import com.orcchg.direcall.data.di.NetworkComponent
import com.orcchg.direcall.data.di.RepositoryComponent
import com.orcchg.direcall.ui.GithubUserListFragment
import dagger.Component


@Component(
    dependencies = [
        NetworkComponent::class,
        RepositoryComponent::class,
        SchedulerComponent::class
    ]
)
interface GithubUsersFeatureComponent {

    @Component.Factory
    interface Factory {
        fun create(
            networkComponent: NetworkComponent,
            repositoryComponent: RepositoryComponent,
            schedulerComponent: SchedulerComponent
        ): GithubUsersFeatureComponent
    }

    fun inject(usersListFragment: GithubUserListFragment)
}