package com.orcchg.direcall.github_user_details.data.repository

import com.orcchg.direcall.github_user_details.data.convert.GithubUserDetailsCloudConverter
import com.orcchg.direcall.github_user_details.data.remote.GithubUserDetailsCloudRest
import com.orcchg.direcall.github_user_details.domain.model.GithubUserDetails
import io.reactivex.Single
import javax.inject.Inject

class GithubUserDetailsRepository @Inject constructor(
    private val userCloud: GithubUserDetailsCloudRest,
    private val userDetailsConverter: GithubUserDetailsCloudConverter
) {

    fun user(login: String): Single<GithubUserDetails> =
        userCloud.userDetails(login).map(userDetailsConverter::convert)
}
