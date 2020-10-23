package com.orcchg.direcall.feature.github_user_details.impl.data.repository

import com.orcchg.direcall.feature.github_user_details.impl.data.convert.GithubUserDetailsCloudConverter
import com.orcchg.direcall.feature.github_user_details.impl.data.remote.GithubUserDetailsCloudRest
import com.orcchg.direcall.feature.github_user_details.pub.model.GithubUserDetails
import io.reactivex.Single
import javax.inject.Inject

class GithubUserDetailsRepositoryImpl @Inject constructor(
    private val cloud: GithubUserDetailsCloudRest,
    private val converter: GithubUserDetailsCloudConverter
) : GithubUserDetailsRepository {

    override fun user(login: String): Single<GithubUserDetails> =
        cloud.userDetails(login).map(converter::convert)
}
