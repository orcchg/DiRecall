package com.orcchg.direcall.core.scheduler.impl.di

import com.orcchg.direcall.core.scheduler.api.SchedulerCoreLibApi
import dagger.Component

@Component(modules = [SchedulerCoreLibModule::class])
interface SchedulerCoreLibComponent : SchedulerCoreLibApi
