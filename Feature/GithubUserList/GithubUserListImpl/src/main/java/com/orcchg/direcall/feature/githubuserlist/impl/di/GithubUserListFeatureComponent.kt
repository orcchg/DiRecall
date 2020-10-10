package com.orcchg.direcall.feature.githubuserlist.impl.di

import com.orcchg.direcall.core.net.api.NetCoreLibApi
import com.orcchg.direcall.core.scheduler.api.SchedulerCoreLibApi
import com.orcchg.direcall.feature.githubuserlist.impl.presentation.viewmodel.GithubUserListViewModel
import dagger.Component

@Component(
    modules = [GithubUserListFeatureModule::class],
    dependencies = [GithubUserListFeatureDependencies::class]
)
interface GithubUserListFeatureComponent : GithubUserListInternalFeatureApi {

    override fun viewModel(): GithubUserListViewModel

    @Component.Factory
    interface Factory {

        fun create(dependencies: GithubUserListFeatureDependencies): GithubUserListFeatureComponent
    }
}

@Component(
    dependencies = [
        NetCoreLibApi::class,
        SchedulerCoreLibApi::class
    ]
)
interface GithubUserListFeatureDependenciesComponent : GithubUserListFeatureDependencies {

    @Component.Factory
    interface Factory {

        fun create(
            netCoreLibApi: NetCoreLibApi,
            schedulerCoreLibApi: SchedulerCoreLibApi
        ): GithubUserListFeatureDependenciesComponent
    }
}
