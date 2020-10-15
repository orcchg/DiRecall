package com.orcchg.direcall.scheduler_api.di

import com.orcchg.direcall.scheduler_api.SchedulersFactory

interface SchedulersApi {

    fun schedulersFactory(): SchedulersFactory
}
