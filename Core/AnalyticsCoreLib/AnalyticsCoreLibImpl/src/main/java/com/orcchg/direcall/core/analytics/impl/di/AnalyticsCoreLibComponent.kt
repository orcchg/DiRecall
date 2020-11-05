package com.orcchg.direcall.core.analytics.impl.di

import com.orcchg.direcall.core.analytics.api.AnalyticsCoreLibApi
import dagger.Component

@Component(modules = [AnalyticsCoreLibModule::class])
interface AnalyticsCoreLibComponent : AnalyticsCoreLibApi
