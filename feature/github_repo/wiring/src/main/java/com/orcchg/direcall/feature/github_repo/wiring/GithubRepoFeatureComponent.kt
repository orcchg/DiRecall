package com.orcchg.direcall.feature.github_repo.wiring

import com.orcchg.direcall.core.network.pub.NetworkCoreApi
import com.orcchg.direcall.core.scheduler.api.SchedulerCoreApi
import com.orcchg.direcall.feature.github_repo.impl.GithubRepoFeatureInternalApi
import dagger.Component

@Component(
    modules = [GithubRepoFeatureModule::class],
    dependencies = [
        NetworkCoreApi::class,
        SchedulerCoreApi::class
    ]
)
interface GithubRepoFeatureComponent : GithubRepoFeatureInternalApi {

    @Component.Factory
    interface Factory {

        fun create(
            networkCoreApi: NetworkCoreApi,
            schedulerCoreApi: SchedulerCoreApi
        ): GithubRepoFeatureComponent
    }
}
