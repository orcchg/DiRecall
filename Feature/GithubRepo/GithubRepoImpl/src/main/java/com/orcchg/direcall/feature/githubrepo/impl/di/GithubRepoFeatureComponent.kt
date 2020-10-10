package com.orcchg.direcall.feature.githubrepo.impl.di

import com.orcchg.direcall.core.net.api.NetCoreLibApi
import com.orcchg.direcall.core.scheduler.api.SchedulerCoreLibApi
import com.orcchg.direcall.feature.githubrepo.impl.presentation.viewmodel.GithubRepoViewModel
import dagger.BindsInstance
import dagger.Component
import javax.inject.Named

@Component(
    modules = [GithubRepoFeatureModule::class],
    dependencies = [GithubRepoFeatureDependencies::class]
)
interface GithubRepoFeatureComponent : GithubRepoInternalFeatureApi {

    override fun viewModel(): GithubRepoViewModel

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance @Named("login") login: String,
            dependencies: GithubRepoFeatureDependencies
        ): GithubRepoFeatureComponent
    }
}

@Component(
    dependencies = [
        NetCoreLibApi::class,
        SchedulerCoreLibApi::class
    ]
)
interface GithubRepoFeatureDependenciesComponent : GithubRepoFeatureDependencies {

    @Component.Factory
    interface Factory {

        fun create(
            netCoreLibApi: NetCoreLibApi,
            schedulerCoreLibApi: SchedulerCoreLibApi
        ): GithubRepoFeatureDependenciesComponent
    }
}
