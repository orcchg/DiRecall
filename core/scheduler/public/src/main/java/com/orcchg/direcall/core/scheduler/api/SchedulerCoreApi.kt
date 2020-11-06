package com.orcchg.direcall.core.scheduler.api

import com.squareup.anvil.annotations.ContributesTo

@ContributesTo(SchedulerScope::class)
interface SchedulerCoreApi {

    fun schedulersFactory(): SchedulersFactory
}
