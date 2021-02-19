package com.orcchg.direcall.github_user_list.di

import com.orcchg.direcall.network.api.di.NetworkApi
import com.orcchg.direcall.scheduler_api.di.SchedulersApi
import com.orcchg.direcall.util.SingletonHolder
import dagger.Component

@Component(
    modules = [GithubUserListFeatureModule::class],
    dependencies = [GithubUserListFeatureDependencies::class]
)
interface GithubUserListFeatureComponent : GithubUserListFeatureApi {

    @Component.Factory
    interface Factory {
        fun create(dependencies: GithubUserListFeatureDependencies): GithubUserListFeatureApi
    }

    companion object : SingletonHolder<GithubUserListFeatureApi, GithubUserListFeatureDependencies>(
        DaggerGithubUserListFeatureComponent.factory()::create
    )

    @Component(
        dependencies = [
            NetworkApi::class,
            SchedulersApi::class
        ]
    )
    interface DependenciesComponent : GithubUserListFeatureDependencies {
        @Component.Factory
        interface Factory {
            fun create(
                networkApi: NetworkApi,
                schedulersApi: SchedulersApi
            ): GithubUserListFeatureDependencies
        }
    }
}
