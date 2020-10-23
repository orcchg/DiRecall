package com.orcchg.direcall

import android.app.Application
import com.orcchg.direcall.core.network.pub.NetworkCoreApi
import com.orcchg.direcall.core.network.wiring.DaggerNetworkCoreComponent
import com.orcchg.direcall.core.scheduler.api.SchedulerCoreApi
import com.orcchg.direcall.core.scheduler.wiring.DaggerSchedulerCoreComponent
import com.orcchg.direcall.core.scopes.ComponentHolder
import com.orcchg.direcall.feature.github_repo.wiring.DaggerGithubRepoFeatureComponent
import com.orcchg.direcall.feature.github_user_details.wiring.DaggerGithubUserDetailsFeatureComponent
import com.orcchg.direcall.feature.github_user_list.wiring.DaggerGithubUserListFeatureComponent
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())

        val networkCoreApi: NetworkCoreApi = DaggerNetworkCoreComponent.create()
        val schedulerCoreApi: SchedulerCoreApi = DaggerSchedulerCoreComponent.create()
        ComponentHolder.components += networkCoreApi
        ComponentHolder.components += schedulerCoreApi
        ComponentHolder.components += DaggerGithubRepoFeatureComponent.factory().create(networkCoreApi, schedulerCoreApi)
        ComponentHolder.components += DaggerGithubUserDetailsFeatureComponent.factory().create(networkCoreApi, schedulerCoreApi)
        ComponentHolder.components += DaggerGithubUserListFeatureComponent.factory().create(networkCoreApi, schedulerCoreApi)
    }
}
