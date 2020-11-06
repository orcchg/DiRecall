package com.orcchg.direcall.core.scheduler.wiring

import com.orcchg.direcall.core.scheduler.api.SchedulerScope
import com.squareup.anvil.annotations.MergeComponent

@MergeComponent(SchedulerScope::class)
interface SchedulerCoreComponent
