package com.orcchg.direcall

import android.app.Application
import com.orcchg.direcall.network.di.networkModule
import com.orcchg.direcall.scheduler.di.schedulersModule
import org.kodein.di.DI
import org.kodein.di.DIAware
import timber.log.Timber

class App : Application() , DIAware{

    override val di = DI {
        import(networkModule)
        import(schedulersModule)
    }

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}
