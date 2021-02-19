package com.orcchg.direcall.scheduler.di

import com.orcchg.direcall.scheduler_api.di.SchedulersApi
import dagger.Component

@Component(modules = [SchedulersModule::class])
interface SchedulersComponent : SchedulersApi {

    companion object {
        val instance: SchedulersApi by lazy { DaggerSchedulersComponent.create() }
    }
}
