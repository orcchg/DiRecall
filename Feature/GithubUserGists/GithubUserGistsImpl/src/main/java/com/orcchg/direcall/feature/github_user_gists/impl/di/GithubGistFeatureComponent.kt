package com.orcchg.direcall.feature.github_user_gists.impl.di

import com.orcchg.direcall.core.net.api.NetCoreLibApi
import com.orcchg.direcall.core.scheduler.api.SchedulerCoreLibApi
import com.orcchg.direcall.feature.github_user_gists.api.di.GithubGistFeatureApi
import dagger.Component

@Component(
    modules = [GithubGistFeatureModule::class],
    dependencies = [
        NetCoreLibApi::class,
        SchedulerCoreLibApi::class
    ]
)
interface GithubGistFeatureComponent : GithubGistFeatureApi {

    @Component.Factory
    interface Factory {

        fun create(
            netCoreLibApi: NetCoreLibApi,
            schedulerCoreLibApi: SchedulerCoreLibApi
        ): GithubGistFeatureComponent
    }
}
