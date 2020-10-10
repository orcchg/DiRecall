package com.orcchg.direcall.feature.githubuserdetails.impl.data.repository

import com.orcchg.direcall.feature.githubuserdetails.api.domain.model.GithubUserDetails
import io.reactivex.Single

interface GithubUserDetailsRepository {

    fun user(login: String): Single<GithubUserDetails>
}
