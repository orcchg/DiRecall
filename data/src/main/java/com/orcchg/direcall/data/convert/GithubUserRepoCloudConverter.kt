package com.orcchg.direcall.data.convert

import com.orcchg.direcall.data.model.GithubUserRepoEntity
import com.orcchg.direcall.domain.model.GithubRepo
import com.orcchg.direcall.util.Converter

class GithubUserRepoCloudConverter : Converter<GithubUserRepoEntity, GithubRepo> {

    override fun convert(from: GithubUserRepoEntity): GithubRepo =
        GithubRepo(
            name = from.name,
            url = from.htmlUrl,
            size = from.size,
            defaultBranch = from.defaultBranch
        )
}