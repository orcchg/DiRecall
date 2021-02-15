package com.orcchg.direcall.domain.di

import com.orcchg.direcall.base.SchedulersFactory
import com.orcchg.direcall.domain.repository.GithubRepository
import com.orcchg.direcall.domain.usecase.GetGithubReposUseCase
import com.orcchg.direcall.domain.usecase.GetGithubUserDetailsUseCase
import com.orcchg.direcall.domain.usecase.GetGithubUsersUseCase
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.provider

val domainModule = DI.Module("domain") {
    fun getGithubReposUseCase(
        repository: GithubRepository,
        schedulersFactory: SchedulersFactory
    ): GetGithubReposUseCase =
        GetGithubReposUseCase(repository, schedulersFactory)

    fun getGithubUserDetailsUseCase(
        repository: GithubRepository,
        schedulersFactory: SchedulersFactory
    ): GetGithubUserDetailsUseCase =
        GetGithubUserDetailsUseCase(repository, schedulersFactory)

    fun getGithubUsersUseCase(
        repository: GithubRepository,
        schedulersFactory: SchedulersFactory
    ): GetGithubUsersUseCase =
        GetGithubUsersUseCase(repository, schedulersFactory)

    bind<GetGithubReposUseCase>() with provider { getGithubReposUseCase(instance(), instance()) }
    bind<GetGithubUserDetailsUseCase>() with provider { getGithubUserDetailsUseCase(instance(), instance()) }
    bind<GetGithubUsersUseCase>() with provider { getGithubUsersUseCase(instance(), instance()) }
}
