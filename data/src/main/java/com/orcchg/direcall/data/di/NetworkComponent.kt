package com.orcchg.direcall.data.di

import com.orcchg.direcall.data.remote.CloudModule
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(modules = [CloudModule::class])
interface NetworkComponent {
    fun retrofit(): Retrofit
}