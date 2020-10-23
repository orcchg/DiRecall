package com.orcchg.direcall.feature.github_user_list.impl.data.convert

import com.orcchg.direcall.feature.github_user_list.impl.model.remote.GithubUserEntity
import com.orcchg.direcall.feature.github_user_list.pub.model.GithubUser
import com.orcchg.direcall.util.Converter
import javax.inject.Inject

class GithubUserCloudConverter @Inject constructor() : Converter<GithubUserEntity, GithubUser> {

    override fun convert(from: GithubUserEntity): GithubUser =
        GithubUser(
            login = from.login,
            avatarUrl = from.avatarUrl
        )
}
