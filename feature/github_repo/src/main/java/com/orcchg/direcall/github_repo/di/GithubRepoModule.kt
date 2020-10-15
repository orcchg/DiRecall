package com.orcchg.direcall.github_repo.di

import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class GithubRepoModule(private val login: String) {

    @Provides
    @Named("login")
    fun login(): String = login
}
