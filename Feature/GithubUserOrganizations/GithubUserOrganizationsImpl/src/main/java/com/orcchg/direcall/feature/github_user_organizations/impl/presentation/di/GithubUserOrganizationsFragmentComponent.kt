package com.orcchg.direcall.feature.github_user_organizations.impl.presentation.di

import com.orcchg.direcall.feature.github_user_organizations.api.di.GithubOrganizationFeatureApi
import com.orcchg.direcall.feature.github_user_organizations.impl.presentation.ui.GithubUserOrganizationsFragment
import dagger.Component

@Component(dependencies = [GithubOrganizationFeatureApi::class])
interface GithubUserOrganizationsFragmentComponent {

    @Component.Factory
    interface Factory {

        fun create(
            githubOrganizationFeatureApi: GithubOrganizationFeatureApi
        ): GithubUserOrganizationsFragmentComponent
    }

    fun inject(target: GithubUserOrganizationsFragment)
}
