package com.orcchg.direcall.feature.github_user_followers.api.interactor

import com.orcchg.direcall.feature.github_user_followers.api.model.GithubFollower
import io.reactivex.Single

interface GithubFollowerInteractor {

    fun followers(login: String): Single<List<GithubFollower>>
}
