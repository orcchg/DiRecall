package com.orcchg.direcall.di

import com.orcchg.direcall.data.convert.GithubRepoCloudConverter
import com.orcchg.direcall.data.convert.GithubUserCloudConverter
import com.orcchg.direcall.data.convert.GithubUserDetailsCloudConverter
import com.orcchg.direcall.data.remote.GithubRepoCloudRest
import com.orcchg.direcall.data.remote.GithubUserCloudRest
import com.orcchg.direcall.data.repository.GithubRepositoryImpl
import com.orcchg.direcall.domain.repository.GithubRepository
import com.orcchg.direcall.domain.usecase.GetGithubReposUseCase
import com.orcchg.direcall.domain.usecase.GetGithubUserDetailsUseCase
import com.orcchg.direcall.domain.usecase.GetGithubUsersUseCase
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.create

val useCaseModule = module {

    fun githubRepoCloudRest(retrofit: Retrofit): GithubRepoCloudRest = retrofit.create()
    fun githubUserDetailsCloudRest(retrofit: Retrofit): GithubUserCloudRest = retrofit.create()

    single { githubRepoCloudRest(retrofit = get()) }
    single { githubUserDetailsCloudRest(retrofit = get()) }
    single { GithubRepoCloudConverter() }
    single { GithubUserCloudConverter() }
    single { GithubUserDetailsCloudConverter() }

    single {
        GithubRepositoryImpl(
            repoCloud = get(),
            userCloud = get(),
            repoConverter = get(),
            userConverter = get(),
            userDetailsConverter = get()
        )
    } bind GithubRepository::class

    factory { GetGithubReposUseCase(repository = get(), schedulersFactory = get()) }
    factory { GetGithubUserDetailsUseCase(repository = get(), schedulersFactory = get()) }
    factory { GetGithubUsersUseCase(repository = get(), schedulersFactory = get()) }
}
