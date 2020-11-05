package com.orcchg.direcall.core.di

import androidx.annotation.MainThread
import com.orcchg.direcall.base.Params
import com.orcchg.direcall.core.di.square.ComponentHolder
import javax.inject.Inject

class FeatureHolderManager @Inject constructor(
    private val holders: Map<Class<*>, FeatureHolder<*>>
) {

    @MainThread
    fun <T> getFeature(key: Class<T>, params: Params): T =
        ComponentHolder.component(key) ?: retrieveFeatureHolder(key).getFeature(params)

    @MainThread
    fun releaseFeature(key: Class<*>) {
        holders[key]?.releaseFeature()
    }

    @Suppress("UNCHECKED_CAST")
    private fun <T> retrieveFeatureHolder(key: Class<T>): FeatureHolder<T> =
        holders[key] as? FeatureHolder<T>
            ?: throw IllegalStateException("Holder for feature ${key.simpleName} not found. Please add it into FeatureHoldersMapModule")
}