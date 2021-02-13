package com.orcchg.direcall.data.di

import com.orcchg.direcall.data.remote.CloudModule
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import toothpick.config.Module
import toothpick.ktp.binding.bind

class NetworkModule : Module() {

    private val loggingInterceptor = CloudModule.loggingInterceptor()
    private val moshi = CloudModule.moshi()
    private val okHttpClient = CloudModule.okHttpClient(loggingInterceptor = loggingInterceptor)
    val retrofit = CloudModule.retrofit(client = okHttpClient, moshi = moshi)

    init {
        bind<HttpLoggingInterceptor>().toInstance(loggingInterceptor)
        bind<Moshi>().toInstance(moshi)
        bind<OkHttpClient>().toInstance(okHttpClient)
        bind<Retrofit>().toInstance(retrofit)
    }
}
