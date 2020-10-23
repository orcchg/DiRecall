package com.orcchg.direcall.core.scheduler.wiring

import com.orcchg.direcall.core.scheduler.api.SchedulersFactory
import com.orcchg.direcall.core.scheduler.impl.SchedulersFactoryImpl
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module
interface SchedulerCoreModule {

    @Binds
    @Reusable
    fun schedulersFactory(impl: SchedulersFactoryImpl): SchedulersFactory
}
