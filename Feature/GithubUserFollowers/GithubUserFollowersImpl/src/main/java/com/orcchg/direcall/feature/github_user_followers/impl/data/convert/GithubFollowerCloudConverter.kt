package com.orcchg.direcall.feature.github_user_followers.impl.data.convert

import com.orcchg.direcall.feature.github_user_followers.api.model.GithubFollower
import com.orcchg.direcall.feature.github_user_followers.impl.model.data.GithubFollowerEntity
import com.orcchg.direcall.util.Converter
import javax.inject.Inject

class GithubFollowerCloudConverter @Inject constructor() : Converter<GithubFollowerEntity, GithubFollower> {

    override fun convert(from: GithubFollowerEntity): GithubFollower =
        GithubFollower(
            id = from.id,
            login = from.login,
            avatarUrl = from.avatarUrl
        )
}
