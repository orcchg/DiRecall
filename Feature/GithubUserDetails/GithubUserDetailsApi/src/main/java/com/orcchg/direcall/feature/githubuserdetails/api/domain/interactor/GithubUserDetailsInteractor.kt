package com.orcchg.direcall.feature.githubuserdetails.api.domain.interactor

import com.orcchg.direcall.feature.githubuserdetails.api.domain.model.GithubUserDetails
import io.reactivex.Single

interface GithubUserDetailsInteractor {

    fun user(login: String): Single<GithubUserDetails>
}
