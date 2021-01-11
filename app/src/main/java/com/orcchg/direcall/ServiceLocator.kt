package com.orcchg.direcall

import com.orcchg.direcall.androidutil.SchedulersFactoryImpl
import com.orcchg.direcall.base.usecase.UseCaseThreadExecutor
import com.orcchg.direcall.data.convert.*
import com.orcchg.direcall.data.remote.CloudModule
import com.orcchg.direcall.data.remote.GithubUserCloudRest
import com.orcchg.direcall.data.repository.GithubRepositoryImpl
import com.orcchg.direcall.domain.usecase.*
import retrofit2.Retrofit
import retrofit2.create

class ServiceLocator {
    private val executor = UseCaseThreadExecutor()
    private val retrofit = CloudModule.retrofit(
        CloudModule.okHttpClient(CloudModule.loggingInterceptor()),
        CloudModule.moshi()
    )
    private val userCloud: GithubUserCloudRest = retrofit.create()
    private val userDetailsConverter = GithubUserDetailsCloudConverter()
    private val userListConverter = GithubUserListCloudConverter()
    private val userRepoListConverter = GithubUserRepoCloudConverter()
    private val userGistCloudConverter = GithubUserGistCloudConverter()
    private val userFollowersCloudConverter = GithubUserFollowersCloudConverter()
    private val userOrgsCloudConverter = GithubUserOrgsCloudConverter()
    private val scheduler = SchedulersFactoryImpl(executor)
    private val gitRepo = GithubRepositoryImpl(
        userCloud = userCloud,
        userDetailsConverter = userDetailsConverter,
        userListConverter = userListConverter,
        userRepoListConverter = userRepoListConverter,
        userGistListCloudConverter = userGistCloudConverter,
        userFollowersCloudConverter = userFollowersCloudConverter,
        userOrgsCloudConverter = userOrgsCloudConverter
    )
    private val getGithubUserDetailsUseCase = GetGithubUserDetailsUseCase(gitRepo, scheduler)
    private val getGithubUsersUseCase = GetGithubUsersUseCase(gitRepo, scheduler)
    private val getGithubUsersRepoUseCase = GetGithubUserRepoUseCase(gitRepo, scheduler)
    private val getGithubUsersFollowersUseCase = GetGithubUserFollowersUseCase(gitRepo, scheduler)
    private val getGithubUsersGistUseCase = GetGithubUserGistUseCase(gitRepo, scheduler)
    private val getGithubUsersOrgsUseCase = GetGithubUserOrgsUseCase(gitRepo, scheduler)

    val serviceLocator = mapOf<Class<*>, Any>(
        UseCaseThreadExecutor::class.java to executor,
        Retrofit::class.java to retrofit,
        GithubUserCloudRest::class.java to userCloud,
        GithubUserDetailsCloudConverter::class.java to userDetailsConverter,
        GithubUserListCloudConverter::class.java to userListConverter,
        GithubUserGistCloudConverter::class.java to userGistCloudConverter,
        GithubUserRepoCloudConverter::class.java to userRepoListConverter,
        GithubUserOrgsCloudConverter::class.java to userOrgsCloudConverter,
        SchedulersFactoryImpl::class.java to scheduler,
        GithubRepositoryImpl::class.java to gitRepo,
        GetGithubUserDetailsUseCase::class.java to getGithubUserDetailsUseCase,
        GetGithubUsersUseCase::class.java to getGithubUsersUseCase,
        GetGithubUserRepoUseCase::class.java to getGithubUsersRepoUseCase,
        GetGithubUserFollowersUseCase::class.java to getGithubUsersFollowersUseCase,
        GetGithubUserOrgsUseCase::class.java to getGithubUsersOrgsUseCase,
        GetGithubUserGistUseCase::class.java to getGithubUsersGistUseCase
    )

    inline fun <reified T> get(): T = serviceLocator[T::class.java]!! as T
}