package com.orcchg.direcall.data.di

import dagger.Component
import javax.inject.Singleton

@Component(modules = [DataModule::class])
@Singleton
interface DataComponent : DataFeatureApi
