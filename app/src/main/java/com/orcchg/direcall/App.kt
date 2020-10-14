package com.orcchg.direcall

import android.app.Application
import com.orcchg.direcall.androidutil.SchedulersFactoryImpl
import com.orcchg.direcall.base.usecase.UseCaseThreadExecutor
import com.orcchg.direcall.data.ServiceLocatorImpl
import com.orcchg.direcall.domain.ServiceLocator
import com.orcchg.direcall.domain.ServiceLocatorProvider
import timber.log.Timber

class App : Application(), ServiceLocatorProvider {

    override val serviceLocator: ServiceLocator =
        ServiceLocatorImpl(
            schedulersFactory = SchedulersFactoryImpl(UseCaseThreadExecutor())
        )

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}
