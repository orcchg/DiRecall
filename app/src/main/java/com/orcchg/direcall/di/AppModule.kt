package com.orcchg.direcall.di

import com.orcchg.direcall.viewmodel.GithubRepoViewModel
import com.orcchg.direcall.viewmodel.GithubUserDetailsViewModel
import com.orcchg.direcall.viewmodel.GithubUserListViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel { (login: String) -> GithubRepoViewModel(login, getGithubReposUseCase = get()) }
    viewModel { (login: String) -> GithubUserDetailsViewModel(login, getGithubUserDetailsUseCase = get()) }
    viewModel { GithubUserListViewModel(getGithubUsersUseCase = get()) }
}
