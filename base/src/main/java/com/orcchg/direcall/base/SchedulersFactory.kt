package com.orcchg.direcall.base

import io.reactivex.Scheduler

interface SchedulersFactory {

    fun io(): Scheduler

    fun main(): Scheduler

    fun useCase(): Scheduler
}
