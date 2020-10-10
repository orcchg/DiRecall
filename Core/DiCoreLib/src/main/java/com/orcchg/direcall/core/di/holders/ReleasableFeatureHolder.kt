package com.orcchg.direcall.core.di.holders

import com.orcchg.direcall.core.di.FeatureContainer

abstract class ReleasableFeatureHolder<T>(
    featureContainer: FeatureContainer
) : AbstractFeatureHolder<T>(featureContainer) {

    override fun releaseFeature(): Boolean {
        if (super.releaseFeature()) {
            onRelease(feature!!)
            feature = null
            dependencies.forEach(featureContainer::releaseFeature)
            dependencies.clear()
            return true
        }
        return false
    }

    protected open fun onRelease(feature: T) = Unit
}
