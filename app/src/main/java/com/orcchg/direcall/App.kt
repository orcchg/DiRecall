package com.orcchg.direcall

import android.app.Application
import com.orcchg.direcall.data.di.DaggerNetworkComponent
import com.orcchg.direcall.data.di.NetworkComponent
import com.orcchg.direcall.di.*
import timber.log.Timber

class App : Application() {
    val networkComponent: NetworkComponent = DaggerNetworkComponent.create()

    val githubUserDetailsComponent: GithubUserDetailsFeatureComponent =
        DaggerGithubUserDetailsFeatureComponent.builder()
            .networkComponent(networkComponent)
            .build()

    val githubUsersListComponent: GithubUsersFeatureComponent =
        DaggerGithubUsersFeatureComponent.builder()
            .networkComponent(networkComponent)
            .build()

    val githubUserFollowersComponent: GithubUserFollowersFeatureComponent =
        DaggerGithubUserFollowersFeatureComponent.builder()
            .networkComponent(networkComponent)
            .build()

    val githubUserGistComponent: GithubUserGistListFeatureComponent =
        DaggerGithubUserGistListFeatureComponent.builder()
            .networkComponent(networkComponent)
            .build()

    val githubUserOrgsComponent: GithubUserOrgsFeatureComponent =
        DaggerGithubUserOrgsFeatureComponent.builder()
            .networkComponent(networkComponent)
            .build()

    val githubUserReposComponent: GithubUserReposFeatureComponent =
        DaggerGithubUserReposFeatureComponent.builder()
            .networkComponent(networkComponent)
            .build()

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}
