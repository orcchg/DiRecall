package com.orcchg.direcall

import android.app.Application
import timber.log.Timber

class App : Application() {
    val serviceLocator = ServiceLocator()

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}
