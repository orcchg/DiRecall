package com.orcchg.direcall

import com.orcchg.direcall.data.di.DaggerDataComponent
import com.orcchg.direcall.di.AppComponent
import com.orcchg.direcall.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import timber.log.Timber

class App : DaggerApplication() {

    lateinit var injector: AppComponent

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerAppComponent.builder()
            .dataFeatureApi(DaggerDataComponent.create())
            .build()
            .also { injector = it }

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}
