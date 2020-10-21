package com.orcchg.direcall.feature.github_user_organizations.impl.di

import com.orcchg.direcall.core.net.api.NetCoreLibApi
import com.orcchg.direcall.core.scheduler.api.SchedulerCoreLibApi
import com.orcchg.direcall.feature.github_user_organizations.api.di.GithubOrganizationFeatureApi
import dagger.BindsInstance
import dagger.Component
import javax.inject.Named

@Component(
    modules = [GithubOrganizationFeatureModule::class],
    dependencies = [GithubOrganizationFeatureDependencies::class]
)
interface GithubOrganizationFeatureComponent : GithubOrganizationFeatureApi {

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance @Named("login") login: String,
            dependencies: GithubOrganizationFeatureDependencies
        ): GithubOrganizationFeatureComponent
    }
}

@Component(
    dependencies = [
        NetCoreLibApi::class,
        SchedulerCoreLibApi::class
    ]
)
interface GithubOrganizationFeatureDependenciesComponent : GithubOrganizationFeatureDependencies {

    @Component.Factory
    interface Factory {

        fun create(
            netCoreLibApi: NetCoreLibApi,
            schedulerCoreLibApi: SchedulerCoreLibApi
        ): GithubOrganizationFeatureDependenciesComponent
    }
}
