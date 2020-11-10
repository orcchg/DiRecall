package com.orcchg.direcall.feature.github_user_followers.dfm.di

import com.orcchg.direcall.core.analytics.api.AnalyticsCoreLibApi
import com.orcchg.direcall.feature.github_user_followers.api.di.GithubFollowerFeatureApi
import com.orcchg.direcall.feature.github_user_followers.dfm.presentation.ui.GithubUserFollowersFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Named

@Component(
    dependencies = [
        AnalyticsCoreLibApi::class,
        GithubFollowerFeatureApi::class
    ]
)
interface GithubUserFollowersFragmentComponent {

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance @Named("login") login: String,
            analyticsCoreLibApi: AnalyticsCoreLibApi,
            githubFollowerFeatureApi: GithubFollowerFeatureApi
        ): GithubUserFollowersFragmentComponent
    }

    fun inject(target: GithubUserFollowersFragment)
}
