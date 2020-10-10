package com.orcchg.direcall.core.di

import androidx.annotation.MainThread
import com.orcchg.direcall.base.Params
import javax.inject.Inject

class FeatureHolderManager @Inject constructor(
    private val holders: Map<Class<*>, FeatureHolder<*>>
) {

    @MainThread
    fun <T> getFeature(key: Class<T>, params: Params): T =
        retrieveFeatureHolder(key).getFeature(params)

    @MainThread
    fun releaseFeature(key: Class<*>) {
        holders[key]?.releaseFeature()
    }

    @Suppress("UNCHECKED_CAST")
    private fun <T> retrieveFeatureHolder(key: Class<T>): FeatureHolder<T> =
        holders[key] as? FeatureHolder<T>
            ?: throw IllegalStateException("Holder for feature ${key.simpleName} not found. Please add it into FeatureHoldersMapModule")
}