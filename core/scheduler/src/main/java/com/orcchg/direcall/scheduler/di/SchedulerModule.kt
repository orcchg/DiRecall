package com.orcchg.direcall.scheduler.di

import com.orcchg.direcall.base.usecase.UseCaseThreadExecutor
import com.orcchg.direcall.scheduler.SchedulersFactoryImpl
import com.orcchg.direcall.scheduler_api.SchedulersFactory
import org.koin.dsl.bind
import org.koin.dsl.module

val schedulerModule = module {

    single { UseCaseThreadExecutor() }

    single {
        SchedulersFactoryImpl(useCaseExecutor = get())
    } bind SchedulersFactory::class
}
