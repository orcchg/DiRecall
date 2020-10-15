package com.orcchg.direcall.scheduler.di

import com.orcchg.direcall.scheduler.SchedulersFactoryImpl
import com.orcchg.direcall.scheduler_api.SchedulersFactory
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module
interface SchedulersModule {

    @Binds
    @Reusable
    fun schedulersFactory(impl: SchedulersFactoryImpl): SchedulersFactory
}
