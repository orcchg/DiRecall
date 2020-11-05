package com.orcchg.direcall.core.analytics.impl

import com.orcchg.direcall.core.analytics.api.Analytics
import timber.log.Timber
import javax.inject.Inject

class AnalyticsImpl @Inject constructor() : Analytics {

    override fun sendEvent(id: String, value: String) {
        Timber.i("Event[$id]: $value")
    }
}
