package com.orcchg.direcall.core.app.impl.di

import android.content.Context
import com.orcchg.direcall.base.Params
import com.orcchg.direcall.core.app.api.AppCoreLibApi
import com.orcchg.direcall.core.app.api.ApplicationContext
import com.orcchg.direcall.core.di.FeatureContainer
import com.orcchg.direcall.core.di.holders.CoreFeatureHolder
import dagger.Reusable
import javax.inject.Inject

@Reusable
class AppCoreLibFeatureHolder @Inject constructor(
    featureContainer: FeatureContainer,
    @ApplicationContext private val context: Context
) : CoreFeatureHolder<AppCoreLibApi>(featureContainer) {

    override fun buildFeature(params: Params): AppCoreLibApi =
        DaggerAppCoreLibComponent.factory().create(context, featureContainer)
}
