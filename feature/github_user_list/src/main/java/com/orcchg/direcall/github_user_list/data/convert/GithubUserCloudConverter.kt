package com.orcchg.direcall.github_user_list.data.convert

import com.orcchg.direcall.github_user_list.data.model.GithubUserEntity
import com.orcchg.direcall.github_user_list.domain.model.GithubUser
import com.orcchg.direcall.util.Converter
import javax.inject.Inject

class GithubUserCloudConverter @Inject constructor() : Converter<GithubUserEntity, GithubUser> {

    override fun convert(from: GithubUserEntity): GithubUser =
        GithubUser(
            login = from.login,
            avatarUrl = from.avatarUrl
        )
}
