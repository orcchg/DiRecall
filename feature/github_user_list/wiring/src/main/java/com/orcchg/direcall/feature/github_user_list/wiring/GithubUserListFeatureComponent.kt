package com.orcchg.direcall.feature.github_user_list.wiring

import com.orcchg.direcall.core.network.pub.NetworkCoreApi
import com.orcchg.direcall.core.scheduler.api.SchedulerCoreApi
import com.orcchg.direcall.feature.github_user_list.impl.GithubUserListFeatureInternalApi
import dagger.Component

@Component(
    modules = [GithubUserListFeatureModule::class],
    dependencies = [
        NetworkCoreApi::class,
        SchedulerCoreApi::class
    ]
)
interface GithubUserListFeatureComponent : GithubUserListFeatureInternalApi {

    @Component.Factory
    interface Factory {

        fun create(
            networkCoreApi: NetworkCoreApi,
            schedulerCoreApi: SchedulerCoreApi
        ): GithubUserListFeatureComponent
    }
}
