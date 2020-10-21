package com.orcchg.direcall.di

import android.app.Application
import android.content.Context
import com.orcchg.direcall.App
import com.orcchg.direcall.core.app.api.ApplicationContext
import com.orcchg.direcall.core.di.FeatureContainer
import dagger.Binds
import dagger.Module

@Module
interface AppModule {

    @Binds
    fun provideApplication(app: App): Application

    @Binds
    fun provideFeatureContainer(app: App): FeatureContainer

    @Binds
    @ApplicationContext
    fun provideApplicationContext(app: App): Context
}
