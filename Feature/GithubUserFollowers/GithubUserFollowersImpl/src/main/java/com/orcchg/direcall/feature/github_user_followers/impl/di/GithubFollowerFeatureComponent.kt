package com.orcchg.direcall.feature.github_user_followers.impl.di

import com.orcchg.direcall.core.net.api.NetCoreLibApi
import com.orcchg.direcall.core.scheduler.api.SchedulerCoreLibApi
import com.orcchg.direcall.feature.github_user_followers.api.di.GithubFollowerFeatureApi
import dagger.Component

@Component(
    modules = [GithubFollowerFeatureModule::class],
    dependencies = [
        NetCoreLibApi::class,
        SchedulerCoreLibApi::class
    ]
)
interface GithubFollowerFeatureComponent : GithubFollowerFeatureApi {

    @Component.Factory
    interface Factory {

        fun create(
            netCoreLibApi: NetCoreLibApi,
            schedulerCoreLibApi: SchedulerCoreLibApi
        ): GithubFollowerFeatureComponent
    }
}
