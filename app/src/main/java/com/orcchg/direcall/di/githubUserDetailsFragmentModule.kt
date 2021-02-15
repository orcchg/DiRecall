package com.orcchg.direcall.di

import com.orcchg.direcall.viewmodel.GithubUserDetailsViewModelFactory
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.factory
import org.kodein.di.instance

fun githubUserDetailsFragment(login: String) = DI.Module("githubUserDetailsFragment") {
    bind<GithubUserDetailsViewModelFactory>() with factory {
        GithubUserDetailsViewModelFactory(login, getGithubUserDetailsUseCase = instance())
    }
}
