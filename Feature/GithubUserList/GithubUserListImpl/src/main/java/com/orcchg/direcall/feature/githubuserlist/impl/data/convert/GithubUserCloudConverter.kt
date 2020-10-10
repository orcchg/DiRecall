package com.orcchg.direcall.feature.githubuserlist.impl.data.convert

import com.orcchg.direcall.feature.githubuserlist.api.domain.model.GithubUser
import com.orcchg.direcall.feature.githubuserlist.impl.model.data.GithubUserEntity
import com.orcchg.direcall.util.Converter
import javax.inject.Inject

class GithubUserCloudConverter @Inject constructor() : Converter<GithubUserEntity, GithubUser> {

    override fun convert(from: GithubUserEntity): GithubUser =
        GithubUser(
            login = from.login,
            avatarUrl = from.avatarUrl
        )
}
