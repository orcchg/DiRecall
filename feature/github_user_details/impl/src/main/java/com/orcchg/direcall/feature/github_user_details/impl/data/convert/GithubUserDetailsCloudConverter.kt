package com.orcchg.direcall.feature.github_user_details.impl.data.convert

import com.orcchg.direcall.feature.github_user_details.impl.model.remote.GithubUserDetailsEntity
import com.orcchg.direcall.feature.github_user_details.pub.model.GithubUserDetails
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
