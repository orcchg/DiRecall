package com.orcchg.direcall.data.repository

import com.orcchg.direcall.data.convert.GithubUserDetailsCloudConverter
import com.orcchg.direcall.data.remote.GithubUserCloudRest
import com.orcchg.direcall.domain.repository.GithubRepository
import com.orcchg.direcall.domain.model.GithubRepo
import com.orcchg.direcall.domain.model.GithubUser
import com.orcchg.direcall.domain.model.GithubUserDetails
import io.reactivex.Single

class GithubRepositoryImpl(
    private val userCloud: GithubUserCloudRest,
    private val userDetailsConverter: GithubUserDetailsCloudConverter
) : GithubRepository {

    override fun repos(login: String): Single<List<GithubRepo>> {
        TODO("implement")
    }

    override fun users(): Single<List<GithubUser>> {
        TODO("implement")
    }

    override fun user(login: String): Single<GithubUserDetails> =
        userCloud.userDetails(login).map(userDetailsConverter::convert)
}
