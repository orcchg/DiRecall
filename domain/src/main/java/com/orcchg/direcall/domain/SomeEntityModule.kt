package com.orcchg.direcall.domain

import com.orcchg.direcall.domain.model.SomeEntity
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
object SomeEntityModule {

    @Provides
    @Named("firstId")
    fun getFirstSomeEntity(): SomeEntity =
        SomeEntity("firstId")

    @Provides
    @Named("secondId")
    fun getSecondSomeEntity(): SomeEntity =
        SomeEntity("secondId")
}
