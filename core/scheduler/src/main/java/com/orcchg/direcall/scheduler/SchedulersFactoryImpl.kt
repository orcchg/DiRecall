package com.orcchg.direcall.scheduler

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.Executor

class SchedulersFactoryImpl(
    private val useCaseExecutor: Executor
) : com.orcchg.direcall.scheduler_api.SchedulersFactory {

    override fun io(): Scheduler = Schedulers.io()

    override fun main(): Scheduler = AndroidSchedulers.mainThread()

    override fun useCase(): Scheduler = Schedulers.from(useCaseExecutor)
}
