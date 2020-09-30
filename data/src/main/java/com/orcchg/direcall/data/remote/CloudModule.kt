package com.orcchg.direcall.data.remote

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

object CloudModule {

    fun okHttpClient(): OkHttpClient = OkHttpClient.Builder().build()

    fun retrofit(client: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .client(client)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl("https://api.github.com/")
            .build()
}
