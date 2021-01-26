package com.orcchg.direcall.data.repository

import com.orcchg.direcall.data.convert.*
import com.orcchg.direcall.data.remote.GithubUserCloudRest
import com.orcchg.direcall.domain.model.*
import com.orcchg.direcall.domain.repository.GithubRepository
import io.reactivex.Single
import javax.inject.Inject

class GithubRepositoryImpl @Inject constructor(
    private val userCloud: GithubUserCloudRest,
    private val userDetailsConverter: GithubUserDetailsCloudConverter,
    private val userListConverter: GithubUserListCloudConverter,
    private val userRepoListConverter: GithubUserRepoCloudConverter,
    private val userGistListCloudConverter: GithubUserGistCloudConverter,
    private val userFollowersCloudConverter: GithubUserFollowersCloudConverter,
    private val userOrgsCloudConverter: GithubUserOrgsCloudConverter
) : GithubRepository {

    override fun repos(login: String): Single<List<GithubRepo>> =
        userCloud.repos(login).map(userRepoListConverter::convertList)

    override fun users(): Single<List<GithubUser>> =
        userCloud.users().map(userListConverter::convertList)

    override fun user(login: String): Single<GithubUserDetails> =
        userCloud.userDetails(login).map(userDetailsConverter::convert)

    override fun gists(login: String): Single<List<GithubUserGist>> =
        userCloud.gists(login).map(userGistListCloudConverter::convertList)

    override fun followers(login: String): Single<List<GithubUserFollower>> =
        userCloud.followers(login).map(userFollowersCloudConverter::convertList)

    override fun organizations(login: String): Single<List<GithubUserOrg>> =
        userCloud.organizations(login).map(userOrgsCloudConverter::convertList)
}
