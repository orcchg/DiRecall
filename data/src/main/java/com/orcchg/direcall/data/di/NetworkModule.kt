package com.orcchg.direcall.data.di

import com.orcchg.direcall.data.remote.CloudModule
import org.koin.dsl.module

val networkModule = module {
    single { CloudModule.loggingInterceptor() }
    single { CloudModule.moshi() }
    single { CloudModule.okHttpClient(loggingInterceptor = get()) }
    single { CloudModule.retrofit(client = get(), moshi = get()) }
}
