package com.orcchg.direcall.feature.github_repo.wiring

import com.orcchg.direcall.core.network.pub.NetworkCoreApi
import com.orcchg.direcall.core.scheduler.api.SchedulerCoreApi
import com.orcchg.direcall.feature.github_repo.pub.GithubRepoFeatureScope
import com.squareup.anvil.annotations.MergeComponent
import dagger.Component

@MergeComponent(
    scope = GithubRepoFeatureScope::class,
    dependencies = [
        NetworkCoreApi::class,
        SchedulerCoreApi::class
    ]
)
interface GithubRepoFeatureComponent {

    @Component.Factory
    interface Factory {
        fun create(
            networkCoreApi: NetworkCoreApi,
            schedulerCoreApi: SchedulerCoreApi
        ): GithubRepoFeatureComponent
    }
}
