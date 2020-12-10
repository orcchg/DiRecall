package com.orcchg.direcall.data.repository

import com.orcchg.direcall.data.convert.GithubUserListCloudConverter
import com.orcchg.direcall.data.convert.GithubUserDetailsCloudConverter
import com.orcchg.direcall.data.convert.GithubUserRepoCloudConverter
import com.orcchg.direcall.data.remote.GithubUserCloudRest
import com.orcchg.direcall.domain.model.GithubRepo
import com.orcchg.direcall.domain.model.GithubUser
import com.orcchg.direcall.domain.model.GithubUserDetails
import com.orcchg.direcall.domain.repository.GithubRepository
import io.reactivex.Single

class GithubRepositoryImpl(
    private val userCloud: GithubUserCloudRest,
    private val userDetailsConverter: GithubUserDetailsCloudConverter,
    private val userListConverter: GithubUserListCloudConverter,
    private val userRepoListConverter: GithubUserRepoCloudConverter
) : GithubRepository {

    override fun repos(login: String): Single<List<GithubRepo>> =
        userCloud.userRepo(login).map(userRepoListConverter::convertList)

    override fun users(): Single<List<GithubUser>> =
        userCloud.users().map(userListConverter::convertList)

    override fun user(login: String): Single<GithubUserDetails> =
        userCloud.userDetails(login).map(userDetailsConverter::convert)
}
