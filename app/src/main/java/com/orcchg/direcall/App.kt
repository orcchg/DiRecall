package com.orcchg.direcall

import android.app.Application
import com.orcchg.direcall.data.di.DaggerNetworkComponent
import com.orcchg.direcall.data.remote.GithubUserCloudRest
import timber.log.Timber

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }

    val networkComponent = DaggerNetworkComponent.create()

    fun provideGithubUserCloudRest(): GithubUserCloudRest =
        networkComponent.rest()
}
