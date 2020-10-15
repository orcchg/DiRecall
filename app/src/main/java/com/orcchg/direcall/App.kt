package com.orcchg.direcall

import android.app.Application
import com.orcchg.direcall.data.di.networkModule
import com.orcchg.direcall.di.appModule
import com.orcchg.direcall.di.schedulerModule
import com.orcchg.direcall.di.useCaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())

        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@App)
            modules(
                networkModule,
                schedulerModule,
                useCaseModule,
                appModule
            )
        }
    }
}
