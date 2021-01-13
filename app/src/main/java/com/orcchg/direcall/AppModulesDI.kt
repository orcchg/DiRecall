package com.orcchg.direcall

import com.orcchg.direcall.androidutil.SchedulersFactoryImpl
import com.orcchg.direcall.base.SchedulersFactory
import com.orcchg.direcall.base.usecase.UseCaseThreadExecutor
import com.orcchg.direcall.data.convert.*
import com.orcchg.direcall.data.remote.CloudModule
import com.orcchg.direcall.data.remote.GithubUserCloudRest
import com.orcchg.direcall.data.repository.GithubRepositoryImpl
import com.orcchg.direcall.domain.repository.GithubRepository
import com.orcchg.direcall.domain.usecase.*
import com.orcchg.direcall.viewmodel.*
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit


val retrofitModule = module {
    fun provideGithubUserCloudRest(retrofit: Retrofit): GithubUserCloudRest =
        retrofit.create(GithubUserCloudRest::class.java)

    single { CloudModule.loggingInterceptor() }
    single { CloudModule.moshi() }
    single { CloudModule.okHttpClient(loggingInterceptor = get()) }
    single { CloudModule.retrofit(client = get(), moshi = get()) }
    single { provideGithubUserCloudRest(retrofit = get()) }
}


val repositoryModule = module {
    single { GithubUserDetailsCloudConverter() }
    single { GithubUserListCloudConverter() }
    single { GithubUserFollowersCloudConverter() }
    single { GithubUserOrgsCloudConverter() }
    single { GithubUserGistCloudConverter() }
    single { GithubUserRepoCloudConverter() }

    single<GithubRepository> {
        GithubRepositoryImpl(
            userCloud = get(),
            userDetailsConverter = get(),
            userListConverter = get(),
            userRepoListConverter = get(),
            userGistListCloudConverter = get(),
            userFollowersCloudConverter = get(),
            userOrgsCloudConverter = get()
        )
    }
}

val useCasesModule = module {
    single { UseCaseThreadExecutor() }
    single<SchedulersFactory> { SchedulersFactoryImpl(useCaseExecutor = get()) }
    single { GetGithubUserDetailsUseCase(repository = get(), schedulersFactory = get()) }
    single { GetGithubUsersUseCase(repository = get(), schedulersFactory = get()) }
    single { GetGithubUserRepoUseCase(repository = get(), schedulersFactory = get()) }
    single { GetGithubUserFollowersUseCase(repository = get(), schedulersFactory = get()) }
    single { GetGithubUserGistUseCase(repository = get(), schedulersFactory = get()) }
    single { GetGithubUserOrgsUseCase(repository = get(), schedulersFactory = get()) }
}

val appModule = module {
    viewModel { (login: String) ->
        GithubUserDetailsViewModel(
            login = login,
            getGithubUserDetailsUseCase = get()
        )
    }
    viewModel { (login: String) ->
        GithubUserFollowersListViewModel(
            login = login,
            getGithubUserFollowersUseCase = get()
        )
    }
    viewModel { (login: String) ->
        GithubUserGistListViewModel(
            login = login,
            getGithubUserGistUseCase = get()
        )
    }
    viewModel { (login: String) ->
        GithubUserReposViewModel(
            login = login,
            getGithubUserRepoUseCase = get()
        )
    }
    viewModel { (login: String) ->
        GithubUserOrgsListViewModel(
            login = login,
            getGithubUserOrgsUseCase = get()
        )
    }
    viewModel { GithubUserListViewModel(getGithubUsersUseCase = get()) }
}