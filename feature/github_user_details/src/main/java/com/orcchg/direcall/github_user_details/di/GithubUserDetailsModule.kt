package com.orcchg.direcall.github_user_details.di

import com.orcchg.direcall.github_user_details.data.convert.GithubUserDetailsCloudConverter
import com.orcchg.direcall.github_user_details.data.remote.GithubUserDetailsCloudRest
import com.orcchg.direcall.github_user_details.data.repository.GithubUserDetailsRepository
import com.orcchg.direcall.github_user_details.domain.usecase.GetGithubUserDetailsUseCase
import com.orcchg.direcall.github_user_details.presentation.viewmodel.GithubUserDetailsViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.create

val githubUserDetailsModule = module {
    fun githubUserDetailsCloudRest(retrofit: Retrofit): GithubUserDetailsCloudRest =
        retrofit.create()

    factory { githubUserDetailsCloudRest(retrofit = get()) }
    factory { GithubUserDetailsCloudConverter() }
    factory {
        GithubUserDetailsRepository(
            userCloud = get(),
            userDetailsConverter = get()
        )
    }
    factory {
        GetGithubUserDetailsUseCase(
            repository = get(),
            schedulersFactory = get()
        )
    }

    viewModel { (login: String) -> GithubUserDetailsViewModel(login, getGithubUserDetailsUseCase = get()) }
}
