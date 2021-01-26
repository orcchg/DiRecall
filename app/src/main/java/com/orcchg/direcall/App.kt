package com.orcchg.direcall

import android.app.Application
import com.orcchg.direcall.data.di.DaggerNetworkComponent
import com.orcchg.direcall.data.di.NetworkComponent
import timber.log.Timber

class App : Application() {
    val networkComponent: NetworkComponent =
        DaggerNetworkComponent.create()

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}
