package com.orcchg.direcall.scheduler

import com.orcchg.direcall.scheduler_api.SchedulersFactory
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.Executor
import javax.inject.Inject

class SchedulersFactoryImpl @Inject constructor(
    private val useCaseExecutor: Executor
) : SchedulersFactory {

    override fun io(): Scheduler = Schedulers.io()

    override fun main(): Scheduler = AndroidSchedulers.mainThread()

    override fun useCase(): Scheduler = Schedulers.from(useCaseExecutor)
}
