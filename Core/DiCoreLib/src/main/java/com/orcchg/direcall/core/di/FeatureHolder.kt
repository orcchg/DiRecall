package com.orcchg.direcall.core.di

import androidx.annotation.MainThread
import com.orcchg.direcall.base.Params

interface FeatureHolder<T> {

    @MainThread
    fun getFeature(params: Params): T

    @MainThread
    fun releaseFeature(): Boolean
}
