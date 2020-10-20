package com.orcchg.direcall.network.api

import com.orcchg.direcall.core_di.Api
import retrofit2.Retrofit

interface NetworkApi : Api {

    fun retrofit(): Retrofit
}
