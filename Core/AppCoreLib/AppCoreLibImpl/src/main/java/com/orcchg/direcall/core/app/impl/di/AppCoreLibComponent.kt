package com.orcchg.direcall.core.app.impl.di

import android.content.Context
import com.orcchg.direcall.core.app.api.AppCoreLibApi
import com.orcchg.direcall.core.app.api.ApplicationContext
import com.orcchg.direcall.core.di.FeatureContainer
import dagger.BindsInstance
import dagger.Component

@Component
interface AppCoreLibComponent : AppCoreLibApi {

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance @ApplicationContext context: Context,
            @BindsInstance featureContainer: FeatureContainer
        ): AppCoreLibComponent
    }
}
