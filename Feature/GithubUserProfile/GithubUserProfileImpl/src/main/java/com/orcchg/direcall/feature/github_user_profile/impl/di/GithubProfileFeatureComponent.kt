package com.orcchg.direcall.feature.github_user_profile.impl.di

import com.orcchg.direcall.core.net.api.NetCoreLibApi
import com.orcchg.direcall.core.scheduler.api.SchedulerCoreLibApi
import com.orcchg.direcall.feature.github_user_profile.api.di.GithubProfileFeatureApi
import dagger.Component

@Component(
    modules = [GithubProfileFeatureModule::class],
    dependencies = [
        NetCoreLibApi::class,
        SchedulerCoreLibApi::class
    ]
)
interface GithubProfileFeatureComponent : GithubProfileFeatureApi {

    @Component.Factory
    interface Factory {

        fun create(
            netCoreLibApi: NetCoreLibApi,
            schedulerCoreLibApi: SchedulerCoreLibApi
        ): GithubProfileFeatureComponent
    }
}
