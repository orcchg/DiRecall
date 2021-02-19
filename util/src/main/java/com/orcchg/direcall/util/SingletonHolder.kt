package com.orcchg.direcall.util

/**
 * @see https://bladecoder.medium.com/kotlin-singletons-with-argument-194ef06edd9e
 */
open class SingletonHolder<out T: Any, in A>(creator: (A, Array<out Any>) -> T) {

    constructor(singleArgCreator: (A) -> T) : this({ arg, _ -> singleArgCreator.invoke(arg) })

    private var creator: ((A, Array<out Any>) -> T)? = creator
    @Volatile private var instance: T? = null

    fun getInstance(arg: A, vararg args: Any): T {
        val i = instance
        if (i != null) {
            return i
        }

        return synchronized(this) {
            val i2 = instance
            if (i2 != null) {
                i2
            } else {
                val created = creator!!(arg, args)
                instance = created
                creator = null
                created
            }
        }
    }
}
