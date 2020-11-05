package com.orcchg.direcall.core.di.square

object ComponentHolder {
    val components = mutableSetOf<Any>()

    inline fun <reified T> component(): T? =
        components
            .filterIsInstance<T>()
            .singleOrNull()

    fun <T> component(key: Class<T>): T? =
        components
            .filterIsInstance(key)
            .singleOrNull()
}
