package com.orcchg.direcall

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())

        startKoin {
            androidContext(this@App)
            androidLogger()
            modules(
                listOf(
                    retrofitModule,
                    useCasesModule,
                    repositoryModule,
                    appModule
                )
            )
        }
    }
}
