package com.orcchg.direcall.feature.github_user_followers.impl.data.repository

import com.orcchg.direcall.feature.github_user_followers.api.model.GithubFollower
import io.reactivex.Single

interface GithubFollowerRepository {

    fun followers(login: String): Single<List<GithubFollower>>
}
