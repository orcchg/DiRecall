package com.orcchg.direcall.data.di

import com.orcchg.direcall.data.convert.GithubRepoCloudConverter
import com.orcchg.direcall.data.convert.GithubUserCloudConverter
import com.orcchg.direcall.data.convert.GithubUserDetailsCloudConverter
import com.orcchg.direcall.data.remote.GithubRepoCloudRest
import com.orcchg.direcall.data.remote.GithubUserCloudRest
import com.orcchg.direcall.data.repository.GithubRepositoryImpl
import com.orcchg.direcall.domain.repository.GithubRepository
import org.kodein.di.*
import retrofit2.Retrofit
import retrofit2.create

val dataModule = DI.Module("data") {
    fun githubRepoCloudRest(retrofit: Retrofit): GithubRepoCloudRest = retrofit.create()
    fun githubUserCloudRest(retrofit: Retrofit): GithubUserCloudRest = retrofit.create()

    bind<GithubRepoCloudRest>() with singleton { githubRepoCloudRest(instance()) }
    bind<GithubUserCloudRest>() with singleton { githubUserCloudRest(instance()) }
    bind<GithubRepoCloudConverter>() with provider { GithubRepoCloudConverter() }
    bind<GithubUserCloudConverter>() with provider { GithubUserCloudConverter() }
    bind<GithubUserDetailsCloudConverter>() with provider { GithubUserDetailsCloudConverter() }
    bind<GithubRepository>() with singleton {
        GithubRepositoryImpl(
            repoCloud = instance(),
            userCloud = instance(),
            repoConverter = instance(),
            userConverter = instance(),
            userDetailsConverter = instance()
        )
    }
}
