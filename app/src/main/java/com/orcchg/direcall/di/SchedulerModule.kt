package com.orcchg.direcall.di

import com.orcchg.direcall.androidutil.SchedulersFactoryImpl
import com.orcchg.direcall.base.SchedulersFactory
import com.orcchg.direcall.base.usecase.UseCaseThreadExecutor
import org.koin.dsl.bind
import org.koin.dsl.module

val schedulerModule = module {

    single { UseCaseThreadExecutor() }

    single {
        SchedulersFactoryImpl(useCaseExecutor = get())
    } bind SchedulersFactory::class
}
