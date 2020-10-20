package com.orcchg.direcall.network

import com.orcchg.direcall.network.api.NetworkApi
import dagger.Component

@Component(modules = [CloudModule::class])
interface NetworkComponent : NetworkApi
