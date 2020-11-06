package com.orcchg.direcall.feature.github_user_list.wiring

import com.orcchg.direcall.core.network.pub.NetworkCoreApi
import com.orcchg.direcall.core.scheduler.api.SchedulerCoreApi
import com.orcchg.direcall.feature.github_user_list.pub.GithubUserListFeatureScope
import com.squareup.anvil.annotations.MergeComponent
import dagger.Component

@MergeComponent(
    scope = GithubUserListFeatureScope::class,
    dependencies = [
        NetworkCoreApi::class,
        SchedulerCoreApi::class
    ]
)
interface GithubUserListFeatureComponent {

    @Component.Factory
    interface Factory {
        fun create(
            networkCoreApi: NetworkCoreApi,
            schedulerCoreApi: SchedulerCoreApi
        ): GithubUserListFeatureComponent
    }
}
