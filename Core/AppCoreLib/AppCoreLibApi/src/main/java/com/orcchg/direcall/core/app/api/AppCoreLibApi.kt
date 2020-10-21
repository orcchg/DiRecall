package com.orcchg.direcall.core.app.api

import android.content.Context
import com.orcchg.direcall.core.di.FeatureContainer

interface AppCoreLibApi {

    @ApplicationContext
    fun context(): Context

    fun featureContainer(): FeatureContainer
}
