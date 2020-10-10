package com.orcchg.direcall.core.net.impl.di

import com.orcchg.direcall.core.net.api.NetCoreLibApi
import dagger.Component

@Component(modules = [NetCoreLibModule::class])
interface NetCoreLibComponent : NetCoreLibApi
