package com.orcchg.direcall.feature.github_user_details.pub.domain.interactor

import com.orcchg.direcall.feature.github_user_details.pub.model.GithubUserDetails
import io.reactivex.Single

interface GithubUserDetailsInteractor {

    fun user(login: String): Single<GithubUserDetails>
}
