package com.orcchg.direcall.core.ui

import androidx.annotation.CallSuper
import com.orcchg.direcall.core.di.FeatureContainer

abstract class BaseViewModel : AutoDisposeViewModel() {

    lateinit var apiClass: Class<*>
    lateinit var featureContainer: FeatureContainer

    @CallSuper
    override fun onCleared() {
        if (::featureContainer.isInitialized) {
            featureContainer.releaseFeature(apiClass)
        }
        super.onCleared()
    }
}
