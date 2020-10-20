package com.orcchg.direcall.scheduler.di

import com.orcchg.direcall.scheduler_api.di.SchedulerApi
import dagger.Component

@Component(modules = [SchedulersModule::class])
interface SchedulerComponent : SchedulerApi
