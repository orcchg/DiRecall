package com.orcchg.direcall.feature.github_user_gists.impl.di

import com.orcchg.direcall.core.net.api.NetCoreLibApi
import com.orcchg.direcall.core.scheduler.di.SchedulerCoreLibApi
import com.orcchg.direcall.feature.github_user_gists.impl.presentation.viewmodel.GithubUserGistsViewModel
import dagger.BindsInstance
import dagger.Component
import javax.inject.Named

@Component(
    modules = [GithubGistFeatureModule::class],
    dependencies = [GithubGistFeatureDependencies::class]
)
interface GithubGistFeatureComponent : GithubGistInternalFeatureApi {

    override fun viewModel(): GithubUserGistsViewModel

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance @Named("login") login: String,
            dependencies: GithubGistFeatureDependencies
        ): GithubGistFeatureComponent
    }
}

@Component(
    dependencies = [
        NetCoreLibApi::class,
        SchedulerCoreLibApi::class
    ]
)
interface GithubGistFeatureDependenciesComponent : GithubGistFeatureDependencies {

    @Component.Factory
    interface Factory {

        fun create(
            netCoreLibApi: NetCoreLibApi,
            schedulerCoreLibApi: SchedulerCoreLibApi
        ): GithubGistFeatureDependenciesComponent
    }
}
