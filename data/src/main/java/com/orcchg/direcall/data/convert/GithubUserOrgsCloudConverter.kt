package com.orcchg.direcall.data.convert

import com.orcchg.direcall.data.model.GithubUserOrgsEntity
import com.orcchg.direcall.domain.model.GithubRepo
import com.orcchg.direcall.domain.model.GithubUserOrg
import com.orcchg.direcall.util.Converter

class GithubUserOrgsCloudConverter : Converter<GithubUserOrgsEntity, GithubUserOrg> {

    override fun convert(from: GithubUserOrgsEntity): GithubUserOrg =
        GithubUserOrg(
            login = from.login,
            url = from.url,
            avatarUrl = from.avatarUrl
        )
}