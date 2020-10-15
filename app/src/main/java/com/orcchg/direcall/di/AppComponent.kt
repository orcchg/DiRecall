package com.orcchg.direcall.di

import com.orcchg.direcall.App
import com.orcchg.direcall.scheduler_api.di.SchedulersApi
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        NetworkModule::class,
        ViewModelModule::class
    ],
    dependencies = [
        SchedulersApi::class
    ]
)
interface AppComponent : AndroidInjector<App>
