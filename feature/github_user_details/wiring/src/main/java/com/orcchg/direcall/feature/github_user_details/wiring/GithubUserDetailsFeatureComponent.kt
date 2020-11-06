package com.orcchg.direcall.feature.github_user_details.wiring

import com.orcchg.direcall.core.network.pub.NetworkCoreApi
import com.orcchg.direcall.core.scheduler.api.SchedulerCoreApi
import com.orcchg.direcall.feature.github_user_details.pub.GithubUserDetailsFeatureScope
import com.squareup.anvil.annotations.MergeComponent
import dagger.Component

@MergeComponent(
    scope = GithubUserDetailsFeatureScope::class,
    dependencies = [
        NetworkCoreApi::class,
        SchedulerCoreApi::class
    ]
)
interface GithubUserDetailsFeatureComponent {

    @Component.Factory
    interface Factory {
        fun create(
            networkCoreApi: NetworkCoreApi,
            schedulerCoreApi: SchedulerCoreApi
        ): GithubUserDetailsFeatureComponent
    }
}
