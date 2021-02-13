package com.orcchg.direcall

import android.app.Application
import timber.log.Timber
import toothpick.ktp.KTP
import toothpick.ktp.binding.bind
import toothpick.ktp.binding.module

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())

        KTP.openRootScope()
            .installModules(module {
                bind<Application>().toInstance { this@App }
            })
    }
}
