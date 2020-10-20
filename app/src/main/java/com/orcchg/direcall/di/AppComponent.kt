package com.orcchg.direcall.di

import com.orcchg.direcall.App
import com.orcchg.direcall.core_di.Api
import dagger.Component

@Component(
    modules = [
        CoreApis::class
    ]
)
interface AppComponent {

    @JvmSuppressWildcards
    val featuresMap: Map<Class<*>, Api>

    fun inject(target: App)
}
