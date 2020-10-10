package com.orcchg.direcall.core.di

import dagger.BindsInstance

interface FeatureHoldersComponent {

    fun getFeatureHolders(): Map<Class<*>, FeatureHolder<*>>

    interface Builder<T> {

        @BindsInstance
        fun featureContainer(featureContainer: FeatureContainer): T
    }
}
