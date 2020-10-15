package com.orcchg.direcall

import android.app.Application
import com.orcchg.direcall.base.usecase.UseCaseThreadExecutor
import com.orcchg.direcall.scheduler.SchedulersFactoryImpl
import com.orcchg.direcall.service_locator.ServiceLocator
import com.orcchg.direcall.service_locator.ServiceLocatorProvider
import com.orcchg.direcall.service_locator.impl.ServiceLocatorImpl
import timber.log.Timber

class App : Application(), ServiceLocatorProvider {

    override val serviceLocator: ServiceLocator =
        ServiceLocatorImpl(SchedulersFactoryImpl(UseCaseThreadExecutor()))

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}
