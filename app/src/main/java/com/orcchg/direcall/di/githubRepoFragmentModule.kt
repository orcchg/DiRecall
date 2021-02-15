package com.orcchg.direcall.di

import com.orcchg.direcall.viewmodel.GithubRepoViewModelFactory
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.factory
import org.kodein.di.instance

fun githubRepoFragmentModule(login: String) = DI.Module("githubRepoFragment") {
    bind<GithubRepoViewModelFactory>() with factory {
        GithubRepoViewModelFactory(login, getGithubReposUseCase = instance())
    }
}
