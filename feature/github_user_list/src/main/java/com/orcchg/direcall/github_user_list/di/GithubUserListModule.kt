package com.orcchg.direcall.github_user_list.di

import androidx.lifecycle.ViewModelProvider
import com.orcchg.direcall.github_user_list.data.convert.GithubUserCloudConverter
import com.orcchg.direcall.github_user_list.data.remote.GithubUserListCloudRest
import com.orcchg.direcall.github_user_list.data.repository.GithubUserListRepository
import com.orcchg.direcall.github_user_list.domain.usecase.GetGithubUsersUseCase
import com.orcchg.direcall.github_user_list.presentation.viewmodel.GithubUserListViewModelFactory
import org.kodein.di.*
import retrofit2.Retrofit
import retrofit2.create

val githubUserListModule = DI.Module("githubUserList") {
    bind<GithubUserListCloudRest>() with singleton { githubUserListCloudRest(instance()) }
    bind<GithubUserCloudConverter>() with provider { GithubUserCloudConverter() }
    bind<GithubUserListRepository>() with singleton { GithubUserListRepository(instance(), instance()) }
    bind<GetGithubUsersUseCase>() with provider { GetGithubUsersUseCase(instance(), instance()) }
    bind<ViewModelProvider.Factory>() with provider { GithubUserListViewModelFactory(instance()) }
}

private fun githubUserListCloudRest(retrofit: Retrofit): GithubUserListCloudRest =
    retrofit.create()
