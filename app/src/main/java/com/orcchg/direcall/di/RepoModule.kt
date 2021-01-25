package com.orcchg.direcall.di

import com.orcchg.direcall.data.convert.*
import com.orcchg.direcall.data.remote.GithubUserCloudRest
import com.orcchg.direcall.data.repository.GithubRepositoryImpl
import dagger.Module
import dagger.Provides


@Module
object RepoModule {

    @Provides
    fun getGitRepo(rest: GithubUserCloudRest) = GithubRepositoryImpl(
        rest,
        GithubUserDetailsCloudConverter(),
        GithubUserListCloudConverter(),
        GithubUserRepoCloudConverter(),
        GithubUserGistCloudConverter(),
        GithubUserFollowersCloudConverter(),
        GithubUserOrgsCloudConverter()
    )
}