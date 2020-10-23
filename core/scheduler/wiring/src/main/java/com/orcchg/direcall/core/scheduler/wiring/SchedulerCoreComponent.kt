package com.orcchg.direcall.core.scheduler.wiring

import com.orcchg.direcall.core.scheduler.api.SchedulerCoreApi
import dagger.Component

@Component(modules = [SchedulerCoreModule::class])
interface SchedulerCoreComponent : SchedulerCoreApi
