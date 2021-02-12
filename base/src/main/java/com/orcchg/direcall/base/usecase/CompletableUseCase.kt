package com.orcchg.direcall.base.usecase

import com.orcchg.direcall.base.Params
import com.orcchg.direcall.core.scheduler.api.SchedulersFactory
import io.reactivex.Completable
import io.reactivex.Scheduler

abstract class CompletableUseCase(
    schedulersFactory: SchedulersFactory
) : UseCase(schedulersFactory) {

    abstract fun sourceImpl(params: Params = Params.EMPTY): Completable

    inline fun sourceImpl(initializer: Params.() -> Unit): Completable =
        sourceImpl(Params().apply(initializer))

    fun source(params: Params = Params.EMPTY): Completable =
        sourceImpl(params)
            .subscribeOn(schedulersFactory.useCase())
            .observeOn(schedulersFactory.main())

    inline fun source(initializer: Params.() -> Unit): Completable =
        source(Params().apply(initializer))

    fun source(scheduler: Scheduler, params: Params = Params.EMPTY): Completable =
        sourceImpl(params).subscribeOn(scheduler)

    inline fun source(scheduler: Scheduler, initializer: Params.() -> Unit): Completable =
        source(scheduler, Params().apply(initializer))
}
