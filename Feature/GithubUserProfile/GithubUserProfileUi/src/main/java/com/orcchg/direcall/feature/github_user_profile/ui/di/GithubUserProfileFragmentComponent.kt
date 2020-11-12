package com.orcchg.direcall.feature.github_user_profile.ui.di

import com.orcchg.direcall.core.analytics.api.AnalyticsCoreLibApi
import com.orcchg.direcall.core.app.api.AppCoreLibApi
import com.orcchg.direcall.feature.github_user_followers.api.di.GithubFollowerFeatureApi
import com.orcchg.direcall.feature.github_user_gists.api.di.GithubGistFeatureApi
import com.orcchg.direcall.feature.github_user_organizations.api.di.GithubOrganizationFeatureApi
import com.orcchg.direcall.feature.github_user_profile.api.di.GithubProfileFeatureApi
import com.orcchg.direcall.feature.github_user_profile.ui.presentation.ui.GithubUserProfileFragment
import com.orcchg.direcall.feature.githubrepo.api.di.GithubRepoFeatureApi
import com.orcchg.direcall.feature.githubuserdetails.api.domain.di.GithubUserDetailsFeatureApi
import dagger.BindsInstance
import dagger.Component
import javax.inject.Named

@Component(
    dependencies = [
        AnalyticsCoreLibApi::class,
        AppCoreLibApi::class,
        GithubFollowerFeatureApi::class,
        GithubGistFeatureApi::class,
        GithubOrganizationFeatureApi::class,
        GithubProfileFeatureApi::class,
        GithubRepoFeatureApi::class,
        GithubUserDetailsFeatureApi::class
    ]
)
interface GithubUserProfileFragmentComponent {

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance @Named("login") login: String,
            analyticsCoreLibApi: AnalyticsCoreLibApi,
            appCoreLibApi: AppCoreLibApi,
            githubFollowerFeatureApi: GithubFollowerFeatureApi,
            githubGistFeatureApi: GithubGistFeatureApi,
            githubOrganizationFeatureApi: GithubOrganizationFeatureApi,
            githubProfileFeatureApi: GithubProfileFeatureApi,
            githubRepoFeatureApi: GithubRepoFeatureApi,
            githubUserDetailsFeatureApi: GithubUserDetailsFeatureApi
        ): GithubUserProfileFragmentComponent
    }

    fun inject(target: GithubUserProfileFragment)
}
