package com.orcchg.direcall.core.analytics.api

interface Analytics {

    fun sendEvent(id: String, value: String)
}
