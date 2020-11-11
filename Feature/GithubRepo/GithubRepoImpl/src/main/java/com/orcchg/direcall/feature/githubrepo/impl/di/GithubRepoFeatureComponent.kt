package com.orcchg.direcall.feature.githubrepo.impl.di

import com.orcchg.direcall.core.analytics.api.AnalyticsCoreLibApi
import com.orcchg.direcall.core.net.api.NetCoreLibApi
import com.orcchg.direcall.core.scheduler.api.SchedulerCoreLibApi
import com.orcchg.direcall.feature.githubrepo.impl.presentation.viewmodel.GithubRepoViewModel
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [GithubRepoFeatureModule::class],
    dependencies = [GithubRepoFeatureDependencies::class]
)
interface GithubRepoFeatureComponent : GithubRepoInternalFeatureApi {

    override fun viewModel(): GithubRepoViewModel

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance @RepoLogin login: String,
            dependencies: GithubRepoFeatureDependencies
        ): GithubRepoFeatureComponent
    }
}

@Component(
    dependencies = [
        AnalyticsCoreLibApi::class,
        NetCoreLibApi::class,
        SchedulerCoreLibApi::class
    ]
)
interface GithubRepoFeatureDependenciesComponent : GithubRepoFeatureDependencies {

    @Component.Factory
    interface Factory {

        fun create(
            analyticsCoreLibApi: AnalyticsCoreLibApi,
            netCoreLibApi: NetCoreLibApi,
            schedulerCoreLibApi: SchedulerCoreLibApi
        ): GithubRepoFeatureDependenciesComponent
    }
}
