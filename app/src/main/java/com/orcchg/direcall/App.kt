package com.orcchg.direcall

import com.orcchg.direcall.base.Params
import com.orcchg.direcall.core.analytics.impl.di.DaggerAnalyticsCoreLibComponent
import com.orcchg.direcall.core.di.FeatureContainer
import com.orcchg.direcall.core.di.FeatureHolderManager
import com.orcchg.direcall.core.di.getFeature
import com.orcchg.direcall.core.di.square.ComponentHolder
import com.orcchg.direcall.di.DaggerAppComponent
import com.orcchg.direcall.feature.github_user_followers.impl.di.DaggerGithubFollowerFeatureComponent
import com.orcchg.direcall.feature.github_user_gists.impl.di.DaggerGithubGistFeatureComponent
import com.orcchg.direcall.feature.github_user_profile.impl.di.DaggerGithubProfileFeatureComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import timber.log.Timber
import javax.inject.Inject

class App : DaggerApplication(), FeatureContainer {

    @Inject lateinit var featureHolderManager: FeatureHolderManager

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerAppComponent.factory().create(this)

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())

        ComponentHolder.components += DaggerAnalyticsCoreLibComponent.create()
        ComponentHolder.components += DaggerGithubFollowerFeatureComponent.factory()
            .create(
                netCoreLibApi = getFeature(),
                schedulerCoreLibApi = getFeature()
            )
        ComponentHolder.components += DaggerGithubGistFeatureComponent.factory()
            .create(
                netCoreLibApi = getFeature(),
                schedulerCoreLibApi = getFeature()
            )
        ComponentHolder.components += DaggerGithubProfileFeatureComponent.factory()
            .create(
                netCoreLibApi = getFeature(),
                schedulerCoreLibApi = getFeature()
            )
    }

    override fun <T> getFeature(key: Class<T>, params: Params): T =
        featureHolderManager.getFeature(key, params)

    override fun releaseFeature(key: Class<*>) {
        featureHolderManager.releaseFeature(key)
    }
}
