package com.orcchg.direcall.github_user_list.di

import com.orcchg.direcall.github_user_list.data.convert.GithubUserCloudConverter
import com.orcchg.direcall.github_user_list.data.remote.GithubUserListCloudRest
import com.orcchg.direcall.github_user_list.data.repository.GithubUserListRepository
import com.orcchg.direcall.github_user_list.domain.usecase.GetGithubUsersUseCase
import com.orcchg.direcall.github_user_list.presentation.viewmodel.GithubUserListViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.create

val githubUserListModule = module {
    fun githubUserListCloudRest(retrofit: Retrofit): GithubUserListCloudRest =
        retrofit.create()

    factory { githubUserListCloudRest(retrofit = get()) }
    factory { GithubUserCloudConverter() }
    factory {
        GithubUserListRepository(
            userCloud = get(),
            userConverter = get()
        )
    }
    factory {
        GetGithubUsersUseCase(
            repository = get(),
            schedulersFactory = get()
        )
    }

    viewModel { GithubUserListViewModel(getGithubUsersUseCase = get()) }
}
