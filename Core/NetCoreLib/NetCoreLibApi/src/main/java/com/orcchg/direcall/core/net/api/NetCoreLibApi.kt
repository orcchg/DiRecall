package com.orcchg.direcall.core.net.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit

interface NetCoreLibApi {

    fun okHttpClient(): OkHttpClient

    fun retrofit(): Retrofit
}
