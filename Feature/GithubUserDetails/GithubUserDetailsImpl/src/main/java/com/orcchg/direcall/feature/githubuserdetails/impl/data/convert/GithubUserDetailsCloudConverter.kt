package com.orcchg.direcall.feature.githubuserdetails.impl.data.convert

import com.orcchg.direcall.feature.githubuserdetails.api.domain.model.GithubUserDetails
import com.orcchg.direcall.feature.githubuserdetails.impl.model.data.GithubUserDetailsEntity
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
