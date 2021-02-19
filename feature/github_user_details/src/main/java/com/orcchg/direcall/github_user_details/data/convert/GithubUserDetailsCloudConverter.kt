package com.orcchg.direcall.github_user_details.data.convert

import com.orcchg.direcall.github_user_details.data.model.GithubUserDetailsEntity
import com.orcchg.direcall.github_user_details.domain.model.GithubUserDetails
import com.orcchg.direcall.util.Converter
import javax.inject.Inject

class GithubUserDetailsCloudConverter @Inject constructor() : Converter<GithubUserDetailsEntity, GithubUserDetails> {

    override fun convert(from: GithubUserDetailsEntity): GithubUserDetails =
        GithubUserDetails(
            login = from.login,
            url = from.reposUrl,
            avatarUrl = from.avatarUrl
        )
}
