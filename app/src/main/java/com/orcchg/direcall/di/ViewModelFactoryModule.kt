package com.orcchg.direcall.di

import com.orcchg.direcall.domain.usecase.*
import com.orcchg.direcall.viewmodel.*
import dagger.Module
import dagger.Provides

@Module(includes = [UseCaseModule::class])
class ViewModelFactoryModule(val login: String) {

    @Provides
    fun userDetailsVMFactory(useCase: GetGithubUserDetailsUseCase) =
        GithubUserDetailsViewModelFactory(login, useCase)

    @Provides
    fun userFollowersVMFactory(useCase: GetGithubUserFollowersUseCase) =
        GithubUserFollowersListViewModelFactory(login, useCase)

    @Provides
    fun userGistVMFactory(useCase: GetGithubUserGistUseCase) =
        GithubUserGistListViewModelFactory(login, useCase)

    @Provides
    fun userReposVMFactory(useCase: GetGithubUserRepoUseCase) =
        GithubUserReposViewModelFactory(login, useCase)

    @Provides
    fun userOrgsVMFactory(useCase: GetGithubUserOrgsUseCase) =
        GithubUserOrgsListViewModelFactory(login, useCase)

    @Provides
    fun usersListVMFactory(useCase: GetGithubUsersUseCase) =
        GithubUserListViewModelFactory(useCase)
}