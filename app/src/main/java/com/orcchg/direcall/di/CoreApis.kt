package com.orcchg.direcall.di

import com.orcchg.direcall.core_di.Api
import com.orcchg.direcall.network.DaggerNetworkComponent
import com.orcchg.direcall.network.api.NetworkApi
import com.orcchg.direcall.scheduler.di.DaggerSchedulerComponent
import com.orcchg.direcall.scheduler_api.di.SchedulerApi
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
object CoreApis {

    @Provides
    @IntoMap
    @ClassKey(NetworkApi::class)
    fun networkApi(): Api = DaggerNetworkComponent.create()

    @Provides
    @IntoMap
    @ClassKey(SchedulerApi::class)
    fun schedulerApi(): Api = DaggerSchedulerComponent.create()
}
