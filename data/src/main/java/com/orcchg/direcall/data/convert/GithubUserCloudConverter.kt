package com.orcchg.direcall.data.convert

import com.orcchg.direcall.data.model.GithubUserEntity
import com.orcchg.direcall.domain.model.GithubUser
import com.orcchg.direcall.util.Converter
import toothpick.InjectConstructor

@InjectConstructor
class GithubUserCloudConverter : Converter<GithubUserEntity, GithubUser> {

    override fun convert(from: GithubUserEntity): GithubUser =
        GithubUser(
            login = from.login,
            avatarUrl = from.avatarUrl
        )
}
