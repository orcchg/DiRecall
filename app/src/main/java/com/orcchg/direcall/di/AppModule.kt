package com.orcchg.direcall.di

import com.orcchg.direcall.viewmodel.GithubRepoViewModel
import com.orcchg.direcall.viewmodel.GithubUserDetailsViewModel
import com.orcchg.direcall.viewmodel.GithubUserListViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel { GithubRepoViewModel(getGithubReposUseCase = get()) }
    viewModel { GithubUserDetailsViewModel(getGithubUserDetailsUseCase = get()) }
    viewModel { GithubUserListViewModel(getGithubUsersUseCase = get()) }
}
