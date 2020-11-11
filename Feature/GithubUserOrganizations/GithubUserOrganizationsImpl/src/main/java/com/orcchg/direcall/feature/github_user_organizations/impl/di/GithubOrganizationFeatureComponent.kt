package com.orcchg.direcall.feature.github_user_organizations.impl.di

import com.orcchg.direcall.core.net.api.NetCoreLibApi
import com.orcchg.direcall.core.scheduler.api.SchedulerCoreLibApi
import com.orcchg.direcall.feature.github_user_organizations.api.di.GithubOrganizationFeatureApi
import dagger.Component

@Component(
    modules = [GithubOrganizationFeatureModule::class],
    dependencies = [
        NetCoreLibApi::class,
        SchedulerCoreLibApi::class
    ]
)
interface GithubOrganizationFeatureComponent : GithubOrganizationFeatureApi {

    @Component.Factory
    interface Factory {

        fun create(
            netCoreLibApi: NetCoreLibApi,
            schedulerCoreLibApi: SchedulerCoreLibApi
        ): GithubOrganizationFeatureComponent
    }
}
