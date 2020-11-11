package com.orcchg.direcall.feature.github_user_gists.dfm.di

import com.orcchg.direcall.core.analytics.api.AnalyticsCoreLibApi
import com.orcchg.direcall.feature.github_user_gists.api.di.GistLogin
import com.orcchg.direcall.feature.github_user_gists.api.di.GithubGistFeatureApi
import com.orcchg.direcall.feature.github_user_gists.dfm.presentation.ui.GithubUserGistsFragment
import dagger.BindsInstance
import dagger.Component

@Component(
    dependencies = [
        AnalyticsCoreLibApi::class,
        GithubGistFeatureApi::class
    ]
)
interface GithubUserGistsFragmentComponent {

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance @GistLogin login: String,
            analyticsCoreLibApi: AnalyticsCoreLibApi,
            githubGistFeatureApi: GithubGistFeatureApi
        ): GithubUserGistsFragmentComponent
    }

    fun inject(target: GithubUserGistsFragment)
}
