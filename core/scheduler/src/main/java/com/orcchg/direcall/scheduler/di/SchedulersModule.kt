package com.orcchg.direcall.scheduler.di

import com.orcchg.direcall.base.usecase.UseCaseThreadExecutor
import com.orcchg.direcall.scheduler.SchedulersFactoryImpl
import com.orcchg.direcall.scheduler_api.SchedulersFactory
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton
import java.util.concurrent.Executor

val schedulersModule = DI.Module("schedulers") {
    bind<Executor>() with singleton { UseCaseThreadExecutor() }
    bind<SchedulersFactory>() with singleton { SchedulersFactoryImpl(instance()) }
}
