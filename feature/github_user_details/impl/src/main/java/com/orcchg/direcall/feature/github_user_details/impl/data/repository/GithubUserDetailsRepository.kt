package com.orcchg.direcall.feature.github_user_details.impl.data.repository

import com.orcchg.direcall.feature.github_user_details.pub.model.GithubUserDetails
import io.reactivex.Single

interface GithubUserDetailsRepository {

    fun user(login: String): Single<GithubUserDetails>
}
