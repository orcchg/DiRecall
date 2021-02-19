package com.orcchg.direcall.github_user_details.di

import com.orcchg.direcall.network.api.di.NetworkApi
import com.orcchg.direcall.scheduler_api.di.SchedulersApi
import com.orcchg.direcall.util.SingletonHolder
import dagger.BindsInstance
import dagger.Component
import javax.inject.Named

@Component(
    modules = [GithubUserDetailsFeatureModule::class],
    dependencies = [GithubUserDetailsFeatureDependencies::class]
)
interface GithubUserDetailsFeatureComponent : GithubUserDetailsFeatureApi {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance @Named("login") login: String,
            dependencies: GithubUserDetailsFeatureDependencies
        ): GithubUserDetailsFeatureApi
    }

    companion object : SingletonHolder<GithubUserDetailsFeatureApi, GithubUserDetailsFeatureDependencies>(
        { dependencies: GithubUserDetailsFeatureDependencies, args: Array<out Any> ->
            DaggerGithubUserDetailsFeatureComponent.factory().create(
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
    interface DependenciesComponent : GithubUserDetailsFeatureDependencies {
        @Component.Factory
        interface Factory {
            fun create(
                networkApi: NetworkApi,
                schedulersApi: SchedulersApi
            ): GithubUserDetailsFeatureDependencies
        }
    }
}
