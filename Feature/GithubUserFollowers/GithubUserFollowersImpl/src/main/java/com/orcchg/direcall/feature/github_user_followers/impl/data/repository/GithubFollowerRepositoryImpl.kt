package com.orcchg.direcall.feature.github_user_followers.impl.data.repository

import com.orcchg.direcall.feature.github_user_followers.api.model.GithubFollower
import com.orcchg.direcall.feature.github_user_followers.impl.data.convert.GithubFollowerCloudConverter
import com.orcchg.direcall.feature.github_user_followers.impl.data.remote.GithubFollowerCloudRest
import io.reactivex.Single
import javax.inject.Inject

class GithubFollowerRepositoryImpl @Inject constructor(
    private val cloud: GithubFollowerCloudRest,
    private val converter: GithubFollowerCloudConverter
) : GithubFollowerRepository {

    override fun followers(login: String): Single<List<GithubFollower>> =
        cloud.followers(login).map(converter::convertList)
}
