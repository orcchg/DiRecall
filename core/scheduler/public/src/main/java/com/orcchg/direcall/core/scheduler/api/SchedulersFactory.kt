package com.orcchg.direcall.core.scheduler.api

import io.reactivex.Scheduler

interface SchedulersFactory {

    fun io(): Scheduler

    fun main(): Scheduler

    fun useCase(): Scheduler
}
