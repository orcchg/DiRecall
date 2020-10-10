package com.orcchg.direcall.core.scheduler.di

import com.orcchg.direcall.base.SchedulersFactory
import com.orcchg.direcall.core.scheduler.SchedulersFactoryImpl
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module
internal interface SchedulerCoreLibModule {

    @Binds
    @Reusable
    fun schedulersFactory(impl: SchedulersFactoryImpl): SchedulersFactory
}
