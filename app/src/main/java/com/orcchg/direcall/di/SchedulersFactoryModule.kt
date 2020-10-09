package com.orcchg.direcall.di

import com.orcchg.direcall.base.SchedulersFactory
import com.orcchg.direcall.androidutil.SchedulersFactoryImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface SchedulersFactoryModule {

    @Binds
    @Singleton
    fun schedulersFactory(impl: SchedulersFactoryImpl): SchedulersFactory
}
