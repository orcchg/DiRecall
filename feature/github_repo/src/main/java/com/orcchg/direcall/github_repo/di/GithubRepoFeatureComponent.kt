package com.orcchg.direcall.github_repo.di

import com.orcchg.direcall.network.api.di.NetworkApi
import com.orcchg.direcall.scheduler_api.di.SchedulersApi
import com.orcchg.direcall.util.SingletonHolder
import dagger.BindsInstance
import dagger.Component
import javax.inject.Named

@Component(
    modules = [GithubRepoFeatureModule::class],
    dependencies = [GithubRepoFeatureDependencies::class]
)
interface GithubRepoFeatureComponent : GithubRepoFeatureApi {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance @Named("login") login: String,
            dependencies: GithubRepoFeatureDependencies
        ): GithubRepoFeatureApi
    }

    companion object : SingletonHolder<GithubRepoFeatureApi, GithubRepoFeatureDependencies>(
        { dependencies: GithubRepoFeatureDependencies, args: Array<out Any> ->
            DaggerGithubRepoFeatureComponent.factory().create(
                login = args[0] as String,
                dependencies = dependencies
            )
        }
    )

    @Component(
        dependencies = [
            NetworkApi::class,
            SchedulersApi::class
        ]
    )
    interface DependenciesComponent : GithubRepoFeatureDependencies {
        @Component.Factory
        interface Factory {
            fun create(
                networkApi: NetworkApi,
                schedulersApi: SchedulersApi
            ): GithubRepoFeatureDependencies
        }
    }
}
