package com.orcchg.direcall.data.di

import com.orcchg.direcall.domain.repository.GithubRepository
import dagger.Component

@Component(
    modules = [RepositoryModule::class],
    dependencies = [NetworkComponent::class]
)
interface RepositoryComponent {
    fun repository(): GithubRepository

    @Component.Factory
    interface Factory {
        fun create(
            networkComponent: NetworkComponent
        ): RepositoryComponent
    }
}
