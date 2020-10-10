package com.orcchg.direcall.feature.githubuserdetails.impl.data.repository

import com.orcchg.direcall.feature.githubuserdetails.api.domain.model.GithubUserDetails
import com.orcchg.direcall.feature.githubuserdetails.impl.data.convert.GithubUserDetailsCloudConverter
import com.orcchg.direcall.feature.githubuserdetails.impl.data.remote.GithubUserDetailsCloudRest
import io.reactivex.Single
import javax.inject.Inject

class GithubUserDetailsRepositoryImpl @Inject constructor(
    private val cloud: GithubUserDetailsCloudRest,
    private val userDetailsConverter: GithubUserDetailsCloudConverter
) : GithubUserDetailsRepository {

    override fun user(login: String): Single<GithubUserDetails> =
        cloud.userDetails(login).map(userDetailsConverter::convert)
}
