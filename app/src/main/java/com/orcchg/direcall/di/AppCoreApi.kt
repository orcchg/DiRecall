package com.orcchg.direcall.di

interface AppCoreApi {

    fun <T> getFeature(key: Class<T>): T
}

inline fun <reified T> AppCoreApi.getFeature(): T =
    getFeature(T::class.java)
