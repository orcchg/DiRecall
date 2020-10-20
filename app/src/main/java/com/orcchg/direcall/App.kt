package com.orcchg.direcall

import android.app.Application
import com.orcchg.direcall.core_di.Api
import com.orcchg.direcall.di.AppCoreApi
import com.orcchg.direcall.di.DaggerAppComponent
import timber.log.Timber
import javax.inject.Inject

class App : Application(), AppCoreApi {

    @JvmSuppressWildcards
    @Inject lateinit var featuresMap: Map<Class<*>, Api>

    @Suppress("Unchecked_Cast")
    override fun <T> getFeature(key: Class<T>): T = featuresMap[key] as T

    override fun onCreate() {
        DaggerAppComponent.create().inject(this)
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}
