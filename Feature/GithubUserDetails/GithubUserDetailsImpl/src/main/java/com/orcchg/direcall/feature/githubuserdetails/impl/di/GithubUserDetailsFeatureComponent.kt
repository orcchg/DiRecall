package com.orcchg.direcall.feature.githubuserdetails.impl.di

import com.orcchg.direcall.core.analytics.api.AnalyticsCoreLibApi
import com.orcchg.direcall.core.net.api.NetCoreLibApi
import com.orcchg.direcall.core.scheduler.api.SchedulerCoreLibApi
import com.orcchg.direcall.feature.githubuserdetails.impl.presentation.viewmodel.GithubUserDetailsViewModel
import dagger.BindsInstance
import dagger.Component
import javax.inject.Named

@Component(
    modules = [GithubUserDetailsFeatureModule::class],
    dependencies = [GithubUserDetailsFeatureDependencies::class]
)
interface GithubUserDetailsFeatureComponent : GithubUserDetailsInternalFeatureApi {

    override fun viewModel(): GithubUserDetailsViewModel

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance @Named("login") login: String,
            dependencies: GithubUserDetailsFeatureDependencies
        ): GithubUserDetailsFeatureComponent
    }
}

@Component(
    dependencies = [
        AnalyticsCoreLibApi::class,
        NetCoreLibApi::class,
        SchedulerCoreLibApi::class
    ]
)
interface GithubUserDetailsFeatureDependenciesComponent : GithubUserDetailsFeatureDependencies {

    @Component.Factory
    interface Factory {

        fun create(
            analyticsCoreLibApi: AnalyticsCoreLibApi,
            netCoreLibApi: NetCoreLibApi,
            schedulerCoreLibApi: SchedulerCoreLibApi
        ): GithubUserDetailsFeatureDependenciesComponent
    }
}
