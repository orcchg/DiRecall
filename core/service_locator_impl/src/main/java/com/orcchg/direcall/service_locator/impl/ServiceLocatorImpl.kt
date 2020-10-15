package com.orcchg.direcall.service_locator.impl

import com.orcchg.direcall.github_repo.data.convert.GithubRepoCloudConverter
import com.orcchg.direcall.github_repo.data.repository.GithubRepoRepository
import com.orcchg.direcall.github_repo.domain.usecase.GetGithubReposUseCase
import com.orcchg.direcall.github_user_details.data.convert.GithubUserDetailsCloudConverter
import com.orcchg.direcall.github_user_details.data.repository.GithubUserDetailsRepository
import com.orcchg.direcall.github_user_details.domain.usecase.GetGithubUserDetailsUseCase
import com.orcchg.direcall.github_user_list.data.convert.GithubUserCloudConverter
import com.orcchg.direcall.github_user_list.data.repository.GithubUserListRepository
import com.orcchg.direcall.github_user_list.domain.usecase.GetGithubUsersUseCase
import com.orcchg.direcall.network.CloudModule
import com.orcchg.direcall.scheduler_api.SchedulersFactory
import com.orcchg.direcall.service_locator.ServiceLocator
import retrofit2.create

class ServiceLocatorImpl(schedulersFactory: SchedulersFactory) : ServiceLocator {

    private val serviceMap: MutableMap<Class<*>, Any> = mutableMapOf()

    init {
        val retrofit = CloudModule.retrofit(
            client = CloudModule.okHttpClient(
                loggingInterceptor = CloudModule.loggingInterceptor()
            ),
            moshi = CloudModule.moshi()
        )

        val githubRepoRepository = GithubRepoRepository(
            repoCloud = retrofit.create(),
            repoConverter = GithubRepoCloudConverter()
        )
        val githubUserDetailsRepository = GithubUserDetailsRepository(
            userCloud = retrofit.create(),
            userDetailsConverter = GithubUserDetailsCloudConverter()
        )
        val githubUserListRepository = GithubUserListRepository(
            userCloud = retrofit.create(),
            userConverter = GithubUserCloudConverter()
        )

        GetGithubReposUseCase(
            githubRepoRepository,
            schedulersFactory
        ).apply { register(this) }

        GetGithubUserDetailsUseCase(
            githubUserDetailsRepository,
            schedulersFactory
        ).apply { register(this) }

        GetGithubUsersUseCase(
            githubUserListRepository,
            schedulersFactory
        ).apply { register(this) }
    }

    override fun register(service: Any) {
        serviceMap[service::class.java] = service
    }

    @Suppress("Unchecked_Cast")
    override fun <T> get(clz: Class<T>): T = serviceMap[clz] as T
}
