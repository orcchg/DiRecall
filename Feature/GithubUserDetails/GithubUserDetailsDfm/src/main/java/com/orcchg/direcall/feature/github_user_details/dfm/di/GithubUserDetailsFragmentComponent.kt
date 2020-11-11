package com.orcchg.direcall.feature.github_user_details.dfm.di

import com.orcchg.direcall.core.analytics.api.AnalyticsCoreLibApi
import com.orcchg.direcall.feature.github_user_details.dfm.presentation.ui.GithubUserDetailsFragment
import com.orcchg.direcall.feature.githubuserdetails.api.domain.di.GithubUserDetailsFeatureApi
import dagger.BindsInstance
import dagger.Component
import javax.inject.Named

@Component(
    dependencies = [
        AnalyticsCoreLibApi::class,
        GithubUserDetailsFeatureApi::class
    ]
)
interface GithubUserDetailsFragmentComponent {

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance @Named("login") login: String,
            analyticsCoreLibApi: AnalyticsCoreLibApi,
            githubUserDetailsFeatureApi: GithubUserDetailsFeatureApi
        ): GithubUserDetailsFragmentComponent
    }

    fun inject(target: GithubUserDetailsFragment)
}
