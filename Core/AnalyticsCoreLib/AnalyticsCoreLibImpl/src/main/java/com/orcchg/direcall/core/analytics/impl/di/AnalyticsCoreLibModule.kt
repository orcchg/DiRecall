package com.orcchg.direcall.core.analytics.impl.di

import com.orcchg.direcall.core.analytics.api.Analytics
import com.orcchg.direcall.core.analytics.impl.AnalyticsImpl
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module
interface AnalyticsCoreLibModule {

    @Binds
    @Reusable
    fun analytics(impl: AnalyticsImpl): Analytics
}
