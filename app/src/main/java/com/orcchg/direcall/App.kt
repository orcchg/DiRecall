package com.orcchg.direcall

import android.app.Application
import com.orcchg.direcall.core.di.lib.ComponentHolder
import com.orcchg.direcall.network.di.NetworkComponent
import com.orcchg.direcall.scheduler.di.SchedulersComponent
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        ComponentHolder.components += NetworkComponent.instance
        ComponentHolder.components += SchedulersComponent.instance
    }
}
