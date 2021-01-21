package com.orcchg.direcall.data.di

import com.orcchg.direcall.data.remote.CloudModule
import com.orcchg.direcall.data.remote.GithubUserCloudRest
import dagger.Component

@Component(modules = [CloudModule::class])
interface NetworkComponent {
    fun rest(): GithubUserCloudRest
}