package com.orcchg.direcall.data.di

import com.orcchg.direcall.data.convert.GithubRepoCloudConverter
import com.orcchg.direcall.data.convert.GithubUserCloudConverter
import com.orcchg.direcall.data.convert.GithubUserDetailsCloudConverter
import com.orcchg.direcall.data.repository.GithubRepositoryImpl
import com.orcchg.direcall.domain.repository.GithubRepository
import retrofit2.Retrofit
import retrofit2.create
import toothpick.config.Module
import toothpick.ktp.binding.bind

class DataModule(retrofit: Retrofit) : Module() {

    init {
        val repository = GithubRepositoryImpl(
            repoCloud = retrofit.create(),
            userCloud = retrofit.create(),
            repoConverter = GithubRepoCloudConverter(),
            userConverter = GithubUserCloudConverter(),
            userDetailsConverter = GithubUserDetailsCloudConverter()
        )

        bind<GithubRepository>().toInstance(repository)
    }
}
