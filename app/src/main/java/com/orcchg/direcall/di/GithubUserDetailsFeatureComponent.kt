package com.orcchg.direcall.di

import com.orcchg.direcall.data.di.NetworkComponent
import com.orcchg.direcall.data.di.RepositoryComponent
import com.orcchg.direcall.ui.GithubUserDetailsFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Named


@Component(
    dependencies = [
        NetworkComponent::class,
        RepositoryComponent::class,
        SchedulerComponent::class
    ]
)
interface GithubUserDetailsFeatureComponent {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance @Named("login") login: String,
            networkComponent: NetworkComponent,
            repositoryComponent: RepositoryComponent,
            schedulerComponent: SchedulerComponent
        ): GithubUserDetailsFeatureComponent
    }

    fun inject(userDetailsFragment: GithubUserDetailsFragment)
}