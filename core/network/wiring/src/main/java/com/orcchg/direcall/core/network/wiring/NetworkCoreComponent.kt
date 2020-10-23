package com.orcchg.direcall.core.network.wiring

import com.orcchg.direcall.core.network.impl.NetworkCoreModule
import com.orcchg.direcall.core.network.pub.NetworkCoreApi
import dagger.Component

@Component(modules = [NetworkCoreModule::class])
interface NetworkCoreComponent : NetworkCoreApi
