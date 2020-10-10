package com.orcchg.direcall.core.di.holders

import com.orcchg.direcall.core.di.FeatureContainer

abstract class CoreFeatureHolder<T>(
    featureContainer: FeatureContainer
) : AbstractFeatureHolder<T>(featureContainer) {

    override fun releaseFeature(): Boolean {
        super.releaseFeature()
        return false
    }
}
