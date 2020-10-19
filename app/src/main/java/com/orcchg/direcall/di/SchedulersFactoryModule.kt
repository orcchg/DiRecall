package com.orcchg.direcall.di

import com.orcchg.direcall.base.SchedulersFactory
import com.orcchg.direcall.androidutil.SchedulersFactoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
interface SchedulersFactoryModule {

    @Binds
    @Singleton
    fun schedulersFactory(impl: SchedulersFactoryImpl): SchedulersFactory
}
