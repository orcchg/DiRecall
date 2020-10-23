package com.orcchg.direcall.base.usecase

import com.orcchg.direcall.core.scheduler.api.SchedulersFactory

abstract class UseCase(protected val schedulersFactory: SchedulersFactory)
