package com.orcchg.direcall.androidutil.di

import com.orcchg.direcall.androidutil.SchedulersFactoryImpl
import com.orcchg.direcall.base.SchedulersFactory
import com.orcchg.direcall.base.usecase.UseCaseThreadExecutor
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton

val executorModule = DI.Module("executor") {
    bind<UseCaseThreadExecutor>() with singleton { UseCaseThreadExecutor() }
    bind<SchedulersFactory>() with singleton { SchedulersFactoryImpl(instance()) }
}
