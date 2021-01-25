package com.orcchg.direcall.di

import com.orcchg.direcall.androidutil.SchedulersFactoryImpl
import com.orcchg.direcall.base.usecase.UseCaseThreadExecutor
import com.orcchg.direcall.data.repository.GithubRepositoryImpl
import com.orcchg.direcall.domain.usecase.*
import dagger.Module
import dagger.Provides

@Module
object UseCaseModule {

    @Provides
    fun executor(): UseCaseThreadExecutor =
        UseCaseThreadExecutor()

    @Provides
    fun scheduler(executor: UseCaseThreadExecutor): SchedulersFactoryImpl =
        SchedulersFactoryImpl(executor)

    @Provides
    fun getGithubUserDetailsUseCase(gitRepo: GithubRepositoryImpl, scheduler: SchedulersFactoryImpl) =
        GetGithubUserDetailsUseCase(gitRepo, scheduler)

    @Provides
    fun getGithubUsersUseCase(gitRepo: GithubRepositoryImpl, scheduler: SchedulersFactoryImpl) =
        GetGithubUsersUseCase(gitRepo, scheduler)

    @Provides
    fun getGithubUserFollowersUseCase(gitRepo: GithubRepositoryImpl, scheduler: SchedulersFactoryImpl) =
        GetGithubUserFollowersUseCase(gitRepo, scheduler)

    @Provides
    fun getGithubUserOrgsUseCase(gitRepo: GithubRepositoryImpl, scheduler: SchedulersFactoryImpl) =
        GetGithubUserOrgsUseCase(gitRepo, scheduler)

    @Provides
    fun getGithubUserGistUseCase(gitRepo: GithubRepositoryImpl, scheduler: SchedulersFactoryImpl) =
        GetGithubUserGistUseCase(gitRepo, scheduler)

    @Provides
    fun getGithubUserRepoUseCase(gitRepo: GithubRepositoryImpl, scheduler: SchedulersFactoryImpl) =
        GetGithubUserRepoUseCase(gitRepo, scheduler)
}