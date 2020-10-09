package com.orcchg.direcall.di

import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class GithubUserDetailsFragmentModule(private val login: String) {

    @Provides
    @Named("login")
    fun login(): String = login
}
