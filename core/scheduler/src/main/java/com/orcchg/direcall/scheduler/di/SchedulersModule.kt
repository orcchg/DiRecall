package com.orcchg.direcall.scheduler.di

import com.orcchg.direcall.base.usecase.UseCaseThreadExecutor
import com.orcchg.direcall.scheduler.SchedulersFactoryImpl
import com.orcchg.direcall.scheduler_api.SchedulersFactory
import dagger.Binds
import dagger.Module
import dagger.Reusable
import java.util.concurrent.Executor

@Module
interface SchedulersModule {
    @Binds
    fun bindExecutor(impl: UseCaseThreadExecutor): Executor

    @Binds
    @Reusable
    fun bindSchedulersFactory(impl: SchedulersFactoryImpl): SchedulersFactory
}
