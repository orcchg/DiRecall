package com.orcchg.direcall.scheduler.di

import com.orcchg.direcall.scheduler.SchedulersFactoryImpl
import com.orcchg.direcall.scheduler_api.SchedulersFactory
import dagger.Binds
import dagger.Module
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
interface SchedulersModule {

    @Binds
    @Reusable
    fun schedulersFactory(impl: SchedulersFactoryImpl): SchedulersFactory
}
