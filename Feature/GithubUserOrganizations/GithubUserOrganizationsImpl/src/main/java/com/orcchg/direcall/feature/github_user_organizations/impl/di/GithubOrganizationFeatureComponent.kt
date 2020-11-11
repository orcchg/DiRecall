package com.orcchg.direcall.feature.github_user_organizations.impl.di

import com.orcchg.direcall.core.analytics.api.AnalyticsCoreLibApi
import com.orcchg.direcall.core.net.api.NetCoreLibApi
import com.orcchg.direcall.core.scheduler.api.SchedulerCoreLibApi
import com.orcchg.direcall.feature.github_user_organizations.api.di.GithubOrganizationFeatureApi
import com.orcchg.direcall.feature.github_user_organizations.api.di.OrgLogin
import com.orcchg.direcall.feature.github_user_organizations.impl.presentation.ui.GithubUserOrganizationsFragment
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [GithubOrganizationFeatureModule::class],
    dependencies = [GithubOrganizationFeatureDependencies::class]
)
interface GithubOrganizationFeatureComponent : GithubOrganizationFeatureApi {

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance @OrgLogin login: String,
            dependencies: GithubOrganizationFeatureDependencies
        ): GithubOrganizationFeatureComponent
    }

    fun inject(target: GithubUserOrganizationsFragment)
}

@Component(
    dependencies = [
        AnalyticsCoreLibApi::class,
        NetCoreLibApi::class,
        SchedulerCoreLibApi::class
    ]
)
interface GithubOrganizationFeatureDependenciesComponent : GithubOrganizationFeatureDependencies {

    @Component.Factory
    interface Factory {

        fun create(
            analyticsCoreLibApi: AnalyticsCoreLibApi,
            netCoreLibApi: NetCoreLibApi,
            schedulerCoreLibApi: SchedulerCoreLibApi
        ): GithubOrganizationFeatureDependenciesComponent
    }
}
