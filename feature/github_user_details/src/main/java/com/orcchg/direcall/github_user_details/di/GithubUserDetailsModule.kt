package com.orcchg.direcall.github_user_details.di

import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class GithubUserDetailsModule(private val login: String) {

    @Provides
    @Named("login")
    fun login(): String = login
}
