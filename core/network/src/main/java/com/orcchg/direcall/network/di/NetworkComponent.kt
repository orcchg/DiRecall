package com.orcchg.direcall.network.di

import com.orcchg.direcall.network.api.di.NetworkApi
import dagger.Component

@Component(modules = [CloudModule::class])
interface NetworkComponent : NetworkApi {

    companion object {
        val instance: NetworkApi by lazy { DaggerNetworkComponent.create() }
    }
}
