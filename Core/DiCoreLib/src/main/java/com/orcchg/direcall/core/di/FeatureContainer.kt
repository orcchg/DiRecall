package com.orcchg.direcall.core.di

import androidx.annotation.MainThread
import com.orcchg.direcall.base.Params

interface FeatureContainer {

    @MainThread
    fun <T> getFeature(key: Class<T>, params: Params = Params.EMPTY): T

    @MainThread
    fun releaseFeature(key: Class<*>)
}

inline fun <reified T> FeatureContainer.getFeature(): T =
    getFeature(T::class.java)

inline fun <reified T> FeatureContainer.getFeature(params: Params): T =
    getFeature(T::class.java, params)

inline fun <reified T> FeatureContainer.getFeature(initializer: Params.() -> Unit): T =
    getFeature(T::class.java, Params().apply(initializer))

inline fun <reified T> FeatureContainer.releaseFeature() {
    releaseFeature(T::class.java)
}
