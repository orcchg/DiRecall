package com.orcchg.direcall.di

import com.orcchg.direcall.androidutil.SchedulersFactoryImpl
import com.orcchg.direcall.base.SchedulersFactory
import com.orcchg.direcall.base.usecase.UseCaseThreadExecutor
import com.orcchg.direcall.data.convert.*
import com.orcchg.direcall.data.remote.GithubUserCloudRest
import com.orcchg.direcall.data.repository.GithubRepositoryImpl
import com.orcchg.direcall.domain.repository.GithubRepository
import dagger.Module
import dagger.Provides

@Module
object UseCaseModule {

    @Provides
    fun gitRepo(
        rest: GithubUserCloudRest,
        userDetailsCloudConverter: GithubUserDetailsCloudConverter,
        userFollowersCloudConverter: GithubUserFollowersCloudConverter,
        userGistCloudConverter: GithubUserGistCloudConverter,
        userOrgsCloudConverter: GithubUserOrgsCloudConverter,
        userRepoCloudConverter: GithubUserRepoCloudConverter,
        userListCloudConverter: GithubUserListCloudConverter
    ): GithubRepository =
        GithubRepositoryImpl(
            rest,
            userDetailsCloudConverter,
            userListCloudConverter,
            userRepoCloudConverter,
            userGistCloudConverter,
            userFollowersCloudConverter,
            userOrgsCloudConverter
        )

    @Provides
    fun scheduler(executor: UseCaseThreadExecutor): SchedulersFactory =
        SchedulersFactoryImpl(executor)
}