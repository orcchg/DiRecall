package com.orcchg.direcall.feature.github_user_organizations.dfm.di

import com.orcchg.direcall.core.analytics.api.AnalyticsCoreLibApi
import com.orcchg.direcall.feature.github_user_organizations.api.di.GithubOrganizationFeatureApi
import com.orcchg.direcall.feature.github_user_organizations.api.di.OrgLogin
import com.orcchg.direcall.feature.github_user_organizations.dfm.presentation.ui.GithubUserOrganizationsFragment
import dagger.BindsInstance
import dagger.Component

@Component(
    dependencies = [
        AnalyticsCoreLibApi::class,
        GithubOrganizationFeatureApi::class
    ]
)
interface GithubUserOrganizationsFragmentComponent {

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance @OrgLogin login: String,
            analyticsCoreLibApi: AnalyticsCoreLibApi,
            githubOrganizationFeatureApi: GithubOrganizationFeatureApi
        ): GithubUserOrganizationsFragmentComponent
    }

    fun inject(target: GithubUserOrganizationsFragment)
}
