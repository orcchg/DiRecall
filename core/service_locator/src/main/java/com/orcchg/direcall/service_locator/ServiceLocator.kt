package com.orcchg.direcall.service_locator

interface ServiceLocator {

    fun register(service: Any)

    fun <T> get(clz: Class<T>): T
}
