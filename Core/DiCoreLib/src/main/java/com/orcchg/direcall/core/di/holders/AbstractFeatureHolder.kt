package com.orcchg.direcall.core.di.holders

import androidx.annotation.CallSuper
import com.orcchg.direcall.base.Params
import com.orcchg.direcall.core.di.FeatureContainer
import com.orcchg.direcall.core.di.FeatureHolder

abstract class AbstractFeatureHolder<T>(
    protected val featureContainer: FeatureContainer
) : FeatureHolder<T> {

    protected var feature: T? = null

    private var refs = 0

    protected var dependencies = mutableListOf<Class<*>>()

    override fun getFeature(params: Params): T {
        refs++
        return feature ?: buildFeature(params).also { feature = it }
    }

    @CallSuper
    override fun releaseFeature(): Boolean {
        refs--
        if (refs == 0) return true
        else if (refs < 0) refs = 0
        return false
    }

    protected fun <D> getDependency(key: Class<D>): D {
        dependencies.add(key)
        return featureContainer.getFeature(key)
    }

    protected inline fun <reified D> getDependency(): D = getDependency(D::class.java)

    protected abstract fun buildFeature(params: Params): T
}
