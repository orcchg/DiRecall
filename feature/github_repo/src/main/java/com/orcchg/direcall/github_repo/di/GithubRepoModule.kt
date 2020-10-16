package com.orcchg.direcall.github_repo.di

import com.orcchg.direcall.github_repo.data.convert.GithubRepoCloudConverter
import com.orcchg.direcall.github_repo.data.remote.GithubRepoCloudRest
import com.orcchg.direcall.github_repo.data.repository.GithubRepoRepository
import com.orcchg.direcall.github_repo.domain.usecase.GetGithubReposUseCase
import com.orcchg.direcall.github_repo.presentation.viewmodel.GithubRepoViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.create

val githubRepoModule = module {
    fun githubRepoCloudRest(retrofit: Retrofit): GithubRepoCloudRest =
        retrofit.create()

    factory { githubRepoCloudRest(retrofit = get()) }
    factory { GithubRepoCloudConverter() }
    factory {
        GithubRepoRepository(
            repoCloud = get(),
            repoConverter = get()
        )
    }
    factory {
        GetGithubReposUseCase(
            repository = get(),
            schedulersFactory = get()
        )
    }

    viewModel { (login: String) -> GithubRepoViewModel(login, getGithubReposUseCase = get()) }
}
