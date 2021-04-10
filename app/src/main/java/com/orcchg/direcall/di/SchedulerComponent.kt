package com.orcchg.direcall.di

import com.orcchg.direcall.base.SchedulersFactory
import dagger.Component

@Component(modules = [SchedulerModule::class])
interface SchedulerComponent {
    fun schedulersFactory(): SchedulersFactory
}