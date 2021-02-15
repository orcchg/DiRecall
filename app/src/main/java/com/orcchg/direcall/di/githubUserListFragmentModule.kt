package com.orcchg.direcall.di

import com.orcchg.direcall.viewmodel.GithubUserListViewModelFactory
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.factory
import org.kodein.di.instance

val githubUserListFragmentModule = DI.Module("githubUserListFragment") {
    bind<GithubUserListViewModelFactory>() with factory {
        GithubUserListViewModelFactory(getGithubUsersUseCase = instance())
    }
}
