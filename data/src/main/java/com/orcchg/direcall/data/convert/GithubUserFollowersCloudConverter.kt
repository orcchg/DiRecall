package com.orcchg.direcall.data.convert

import com.orcchg.direcall.data.model.GithubUserFollowersEntity
import com.orcchg.direcall.domain.model.GithubUserFollower
import com.orcchg.direcall.util.Converter

class GithubUserFollowersCloudConverter : Converter<GithubUserFollowersEntity, GithubUserFollower> {

    override fun convert(from: GithubUserFollowersEntity): GithubUserFollower =
        GithubUserFollower(
            login = from.login,
            avatarUrl = from.avatarUrl,
            url = from.url
        )
}