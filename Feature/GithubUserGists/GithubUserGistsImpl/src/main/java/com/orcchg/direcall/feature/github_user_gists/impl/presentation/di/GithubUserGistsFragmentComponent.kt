package com.orcchg.direcall.feature.github_user_gists.impl.presentation.di

import com.orcchg.direcall.core.app.api.AppCoreLibApi
import com.orcchg.direcall.feature.github_user_gists.impl.presentation.ui.GithubUserGistsFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Named

@Component(dependencies = [AppCoreLibApi::class])
interface GithubUserGistsFragmentComponent {

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance @Named("login") login: String,
            appCoreLibApi: AppCoreLibApi
        ): GithubUserGistsFragmentComponent
    }

    fun inject(target: GithubUserGistsFragment)
}
