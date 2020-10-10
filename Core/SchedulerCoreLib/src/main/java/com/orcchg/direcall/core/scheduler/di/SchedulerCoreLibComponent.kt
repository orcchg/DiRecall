package com.orcchg.direcall.core.scheduler.di

import dagger.Component

@Component(modules = [SchedulerCoreLibModule::class])
interface SchedulerCoreLibComponent : SchedulerCoreLibApi
