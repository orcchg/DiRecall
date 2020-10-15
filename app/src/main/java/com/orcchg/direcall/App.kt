package com.orcchg.direcall

import com.orcchg.direcall.di.DaggerAppComponent
import com.orcchg.direcall.scheduler.di.DaggerSchedulersComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import timber.log.Timber

class App : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerAppComponent.builder()
            .schedulersApi(DaggerSchedulersComponent.create())
            .build()

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}
