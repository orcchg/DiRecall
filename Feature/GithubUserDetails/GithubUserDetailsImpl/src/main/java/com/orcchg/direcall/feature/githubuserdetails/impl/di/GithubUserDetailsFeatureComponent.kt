package com.orcchg.direcall.feature.githubuserdetails.impl.di

import com.orcchg.direcall.core.net.api.NetCoreLibApi
import com.orcchg.direcall.core.scheduler.api.SchedulerCoreLibApi
import com.orcchg.direcall.feature.githubuserdetails.api.domain.di.GithubUserDetailsFeatureApi
import dagger.Component

@Component(
    modules = [GithubUserDetailsFeatureModule::class],
    dependencies = [GithubUserDetailsFeatureDependencies::class]
)
interface GithubUserDetailsFeatureComponent : GithubUserDetailsFeatureApi {

    @Component.Factory
    interface Factory {

        fun create(
            dependencies: GithubUserDetailsFeatureDependencies
        ): GithubUserDetailsFeatureComponent
    }
}

@Component(
    dependencies = [
        NetCoreLibApi::class,
        SchedulerCoreLibApi::class
    ]
)
interface GithubUserDetailsFeatureDependenciesComponent : GithubUserDetailsFeatureDependencies {

    @Component.Factory
    interface Factory {

        fun create(
            netCoreLibApi: NetCoreLibApi,
            schedulerCoreLibApi: SchedulerCoreLibApi
        ): GithubUserDetailsFeatureDependenciesComponent
    }
}
