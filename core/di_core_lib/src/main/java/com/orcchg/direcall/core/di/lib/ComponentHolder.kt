package com.orcchg.direcall.core.di.lib

object ComponentHolder {

    val components = mutableSetOf<Any>()

    inline fun <reified T> component(): T = components
        .filterIsInstance<T>()
        .single()
}
