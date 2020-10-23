package com.orcchg.direcall.feature.github_user_details.wiring

import com.orcchg.direcall.core.network.pub.NetworkCoreApi
import com.orcchg.direcall.core.scheduler.api.SchedulerCoreApi
import com.orcchg.direcall.feature.github_user_details.impl.GithubUserDetailsFeatureInternalApi
import dagger.Component

@Component(
    modules = [GithubUserDetailsFeatureModule::class],
    dependencies = [
        NetworkCoreApi::class,
        SchedulerCoreApi::class
    ]
)
interface GithubUserDetailsFeatureComponent : GithubUserDetailsFeatureInternalApi {

    @Component.Factory
    interface Factory {

        fun create(
            networkCoreApi: NetworkCoreApi,
            schedulerCoreApi: SchedulerCoreApi
        ): GithubUserDetailsFeatureComponent
    }
}
