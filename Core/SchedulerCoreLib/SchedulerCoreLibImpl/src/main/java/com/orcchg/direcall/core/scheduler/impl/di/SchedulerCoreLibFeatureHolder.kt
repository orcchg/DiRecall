package com.orcchg.direcall.core.scheduler.impl.di

import com.orcchg.direcall.base.Params
import com.orcchg.direcall.core.di.FeatureContainer
import com.orcchg.direcall.core.di.holders.CoreFeatureHolder
import com.orcchg.direcall.core.scheduler.api.SchedulerCoreLibApi
import dagger.Reusable
import javax.inject.Inject

@Reusable
class SchedulerCoreLibFeatureHolder @Inject constructor(
    featureContainer: FeatureContainer
) : CoreFeatureHolder<SchedulerCoreLibApi>(featureContainer) {

    override fun buildFeature(params: Params): SchedulerCoreLibApi =
        DaggerSchedulerCoreLibComponent.create()
}
