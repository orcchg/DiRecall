package com.orcchg.direcall

import android.app.Application
import com.orcchg.direcall.androidutil.di.executorModule
import com.orcchg.direcall.data.di.dataModule
import com.orcchg.direcall.data.di.networkModule
import com.orcchg.direcall.domain.di.domainModule
import org.kodein.di.DI
import org.kodein.di.DIAware
import timber.log.Timber

class App : Application(), DIAware {

    override val di: DI by DI.lazy {
        import(executorModule)
        import(networkModule)
        import(dataModule)
        import(domainModule)
    }

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}
