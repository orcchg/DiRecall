package com.orcchg.direcall.feature.github_user_profile.demo

import android.app.Application
import com.orcchg.direcall.base.Params
import com.orcchg.direcall.core.analytics.impl.di.DaggerAnalyticsCoreLibComponent
import com.orcchg.direcall.core.app.impl.di.DaggerAppCoreLibComponent
import com.orcchg.direcall.core.di.FeatureContainer
import com.orcchg.direcall.core.di.getFeature
import com.orcchg.direcall.core.di.square.ComponentHolder
import com.orcchg.direcall.core.net.impl.di.DaggerNetCoreLibComponent
import com.orcchg.direcall.core.scheduler.impl.di.DaggerSchedulerCoreLibComponent
import com.orcchg.direcall.feature.github_repo.fake.di.DaggerFakeGithubRepoFeatureComponent
import com.orcchg.direcall.feature.github_user_details.fake.di.DaggerFakeGithubUserDetailsFeatureComponent
import com.orcchg.direcall.feature.github_user_followers.fake.di.DaggerFakeGithubFollowerFeatureComponent
import com.orcchg.direcall.feature.github_user_gists.fake.di.DaggerFakeGithubGistFeatureComponent
import com.orcchg.direcall.feature.github_user_organizations.fake.di.DaggerFakeGithubOrganizationFeatureComponent
import com.orcchg.direcall.feature.github_user_profile.impl.di.DaggerGithubProfileFeatureComponent
import timber.log.Timber

class DemoApp : Application(), FeatureContainer {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())

        // real core libs
        ComponentHolder.components += DaggerAnalyticsCoreLibComponent.create()
        ComponentHolder.components += DaggerAppCoreLibComponent.factory().create(this, this)
        ComponentHolder.components += DaggerNetCoreLibComponent.create()
        ComponentHolder.components += DaggerSchedulerCoreLibComponent.create()

        // fakes features
        ComponentHolder.components += DaggerFakeGithubFollowerFeatureComponent.create()
        ComponentHolder.components += DaggerFakeGithubGistFeatureComponent.create()
        ComponentHolder.components += DaggerFakeGithubOrganizationFeatureComponent.create()
        ComponentHolder.components += DaggerFakeGithubRepoFeatureComponent.create()
        ComponentHolder.components += DaggerFakeGithubUserDetailsFeatureComponent.create()

        // real feature under test
        ComponentHolder.components += DaggerGithubProfileFeatureComponent.factory()
            .create(
                netCoreLibApi = getFeature(),
                schedulerCoreLibApi = getFeature()
            )
    }

    override fun <T> getFeature(key: Class<T>, params: Params): T =
        ComponentHolder.component(key) ?: throw NonSuchFeatureException(key.toString())

    override fun releaseFeature(key: Class<*>) {
        // no-op
    }
}
