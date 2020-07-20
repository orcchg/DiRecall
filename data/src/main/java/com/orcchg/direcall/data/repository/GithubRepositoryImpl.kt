package com.orcchg.direcall.data.repository

import com.orcchg.direcall.data.convert.GithubRepoCloudConverter
import com.orcchg.direcall.data.convert.GithubUserCloudConverter
import com.orcchg.direcall.data.convert.GithubUserDetailsCloudConverter
import com.orcchg.direcall.data.remote.GithubRepoCloudRest
import com.orcchg.direcall.data.remote.GithubUserCloudRest
import com.orcchg.direcall.domain.repository.GithubRepository
import com.orcchg.direcall.domain.model.GithubRepo
import com.orcchg.direcall.domain.model.GithubUser
import com.orcchg.direcall.domain.model.GithubUserDetails
import io.reactivex.Single

class GithubRepositoryImpl(
    private val repoCloud: GithubRepoCloudRest,
    private val userCloud: GithubUserCloudRest,
    private val repoConverter: GithubRepoCloudConverter,
    private val userConverter: GithubUserCloudConverter,
    private val userDetailsConverter: GithubUserDetailsCloudConverter
) : GithubRepository {

    override fun repos(login: String): Single<List<GithubRepo>> =
        repoCloud.repos(login).map(repoConverter::convertList)

    override fun users(): Single<List<GithubUser>> =
        userCloud.users().map(userConverter::convertList)

    override fun user(login: String): Single<GithubUserDetails> =
        userCloud.userDetails(login).map(userDetailsConverter::convert)
}
