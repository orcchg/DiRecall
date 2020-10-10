package com.orcchg.direcall.core.net.impl.di

import com.orcchg.direcall.base.Params
import com.orcchg.direcall.core.di.FeatureContainer
import com.orcchg.direcall.core.di.holders.CoreFeatureHolder
import com.orcchg.direcall.core.net.api.NetCoreLibApi
import dagger.Reusable
import javax.inject.Inject

@Reusable
class NetCoreLibFeatureHolder @Inject constructor(
    featureContainer: FeatureContainer
) : CoreFeatureHolder<NetCoreLibApi>(featureContainer) {

    override fun buildFeature(params: Params): NetCoreLibApi =
        DaggerNetCoreLibComponent.create()
}
