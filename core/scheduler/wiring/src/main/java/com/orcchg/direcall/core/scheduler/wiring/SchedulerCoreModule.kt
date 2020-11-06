package com.orcchg.direcall.core.scheduler.wiring

import com.orcchg.direcall.core.scheduler.api.SchedulerScope
import com.orcchg.direcall.core.scheduler.api.SchedulersFactory
import com.orcchg.direcall.core.scheduler.impl.SchedulersFactoryImpl
import com.squareup.anvil.annotations.ContributesTo
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module
@ContributesTo(SchedulerScope::class)
interface SchedulerCoreModule {

    @Binds
    @Reusable
    fun schedulersFactory(impl: SchedulersFactoryImpl): SchedulersFactory
}
