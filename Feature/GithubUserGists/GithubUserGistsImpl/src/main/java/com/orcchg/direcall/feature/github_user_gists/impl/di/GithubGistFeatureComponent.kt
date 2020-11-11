package com.orcchg.direcall.feature.github_user_gists.impl.di

import com.orcchg.direcall.core.analytics.api.AnalyticsCoreLibApi
import com.orcchg.direcall.core.net.api.NetCoreLibApi
import com.orcchg.direcall.core.scheduler.api.SchedulerCoreLibApi
import com.orcchg.direcall.feature.github_user_gists.impl.presentation.viewmodel.GithubUserGistsViewModel
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [GithubGistFeatureModule::class],
    dependencies = [GithubGistFeatureDependencies::class]
)
interface GithubGistFeatureComponent : GithubGistInternalFeatureApi {

    override fun viewModel(): GithubUserGistsViewModel

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance @GistLogin login: String,
            dependencies: GithubGistFeatureDependencies
        ): GithubGistFeatureComponent
    }
}

@Component(
    dependencies = [
        AnalyticsCoreLibApi::class,
        NetCoreLibApi::class,
        SchedulerCoreLibApi::class
    ]
)
interface GithubGistFeatureDependenciesComponent : GithubGistFeatureDependencies {

    @Component.Factory
    interface Factory {

        fun create(
            analyticsCoreLibApi: AnalyticsCoreLibApi,
            netCoreLibApi: NetCoreLibApi,
            schedulerCoreLibApi: SchedulerCoreLibApi
        ): GithubGistFeatureDependenciesComponent
    }
}
