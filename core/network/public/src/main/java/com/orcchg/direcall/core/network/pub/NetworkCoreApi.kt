package com.orcchg.direcall.core.network.pub

import com.squareup.anvil.annotations.ContributesTo
import retrofit2.Retrofit

@ContributesTo(NetworkScope::class)
interface NetworkCoreApi {

    fun retrofit(): Retrofit
}
