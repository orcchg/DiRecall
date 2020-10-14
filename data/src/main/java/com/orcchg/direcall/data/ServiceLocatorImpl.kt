package com.orcchg.direcall.data

import com.orcchg.direcall.base.SchedulersFactory
import com.orcchg.direcall.data.convert.GithubRepoCloudConverter
import com.orcchg.direcall.data.convert.GithubUserCloudConverter
import com.orcchg.direcall.data.convert.GithubUserDetailsCloudConverter
import com.orcchg.direcall.data.remote.CloudModule
import com.orcchg.direcall.data.repository.GithubRepositoryImpl
import com.orcchg.direcall.domain.ServiceLocator
import com.orcchg.direcall.domain.repository.GithubRepository
import com.orcchg.direcall.domain.usecase.GetGithubReposUseCase
import com.orcchg.direcall.domain.usecase.GetGithubUserDetailsUseCase
import com.orcchg.direcall.domain.usecase.GetGithubUsersUseCase
import retrofit2.Retrofit
import retrofit2.create

class ServiceLocatorImpl(
    private val schedulersFactory: SchedulersFactory
) : ServiceLocator {

    private val retrofit: Retrofit
    private val repository: GithubRepository

    init {
        retrofit = CloudModule.retrofit(
            client = CloudModule.okHttpClient(
                loggingInterceptor = CloudModule.loggingInterceptor()
            ),
            moshi = CloudModule.moshi()
        )

        repository = GithubRepositoryImpl(
            repoCloud = retrofit.create(),
            userCloud = retrofit.create(),
            repoConverter = GithubRepoCloudConverter(),
            userConverter = GithubUserCloudConverter(),
            userDetailsConverter = GithubUserDetailsCloudConverter()
        )
    }

    override val githubReposUseCase: GetGithubReposUseCase by lazy {
        GetGithubReposUseCase(repository, schedulersFactory)
    }

    override val githubUserDetailsUseCase: GetGithubUserDetailsUseCase by lazy {
        GetGithubUserDetailsUseCase(repository, schedulersFactory)
    }

    override val githubUsersUseCase: GetGithubUsersUseCase by lazy {
        GetGithubUsersUseCase(repository, schedulersFactory)
    }
}
