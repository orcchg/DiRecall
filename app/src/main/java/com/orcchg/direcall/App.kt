package com.orcchg.direcall

import android.app.Application
import com.orcchg.direcall.data.di.DaggerNetworkComponent
import com.orcchg.direcall.data.di.DaggerRepositoryComponent
import com.orcchg.direcall.data.di.NetworkComponent
import com.orcchg.direcall.data.di.RepositoryComponent
import com.orcchg.direcall.di.SchedulerComponent
import com.orcchg.direcall.di.DaggerSchedulerComponent
import timber.log.Timber

class App : Application() {
    val networkComponent: NetworkComponent by lazy(LazyThreadSafetyMode.NONE) { DaggerNetworkComponent.create() }
    val repositoryComponent: RepositoryComponent by lazy(LazyThreadSafetyMode.NONE) { DaggerRepositoryComponent.factory().create(networkComponent) }
    val schedulerComponent: SchedulerComponent by lazy(LazyThreadSafetyMode.NONE) { DaggerSchedulerComponent.create() }

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}
