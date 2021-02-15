package com.orcchg.direcall.data.di

import com.orcchg.direcall.data.remote.CloudModule
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton
import retrofit2.Retrofit

val networkModule = DI.Module("network") {
    bind<HttpLoggingInterceptor>() with instance(CloudModule.loggingInterceptor())
    bind<Moshi>() with instance(CloudModule.moshi())
    bind<OkHttpClient>() with singleton { CloudModule.okHttpClient(instance()) }
    bind<Retrofit>() with singleton { CloudModule.retrofit(instance(), instance()) }
}
