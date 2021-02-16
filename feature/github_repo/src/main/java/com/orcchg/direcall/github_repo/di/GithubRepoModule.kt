package com.orcchg.direcall.github_repo.di

import androidx.lifecycle.ViewModelProvider
import com.orcchg.direcall.github_repo.data.convert.GithubRepoCloudConverter
import com.orcchg.direcall.github_repo.data.remote.GithubRepoCloudRest
import com.orcchg.direcall.github_repo.data.repository.GithubRepoRepository
import com.orcchg.direcall.github_repo.domain.usecase.GetGithubReposUseCase
import com.orcchg.direcall.github_repo.presentation.viewmodel.GithubRepoViewModelFactory
import org.kodein.di.*
import retrofit2.Retrofit
import retrofit2.create

fun githubRepoModule(login: String) = DI.Module("githubRepo") {
    bind<GithubRepoCloudRest>() with singleton { githubRepoCloudRest(instance()) }
    bind<GithubRepoCloudConverter>() with provider { GithubRepoCloudConverter() }
    bind<GithubRepoRepository>() with singleton { GithubRepoRepository(instance(), instance()) }
    bind<GetGithubReposUseCase>() with provider { GetGithubReposUseCase(instance(), instance()) }
    bind<ViewModelProvider.Factory>() with provider { GithubRepoViewModelFactory(login, instance()) }
}

private fun githubRepoCloudRest(retrofit: Retrofit): GithubRepoCloudRest =
    retrofit.create()
