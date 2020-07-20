package com.orcchg.direcall.data.convert

import com.orcchg.direcall.data.model.GithubUserDetailsEntity
import com.orcchg.direcall.domain.model.GithubUserDetails
import com.orcchg.direcall.util.Converter

class GithubUserDetailsCloudConverter : Converter<GithubUserDetailsEntity, GithubUserDetails> {

    override fun convert(from: GithubUserDetailsEntity): GithubUserDetails =
        GithubUserDetails(
            login = from.login,
            url = from.reposUrl,
            avatarUrl = from.avatarUrl
        )
}
