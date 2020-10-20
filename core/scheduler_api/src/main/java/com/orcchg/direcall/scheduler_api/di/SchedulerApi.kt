package com.orcchg.direcall.scheduler_api.di

import com.orcchg.direcall.core_di.Api
import com.orcchg.direcall.scheduler_api.SchedulersFactory

interface SchedulerApi : Api {

    fun schedulersFactory(): SchedulersFactory
}
