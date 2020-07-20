package com.orcchg.direcall.data.convert

import com.orcchg.direcall.data.model.GithubRepoEntity
import com.orcchg.direcall.domain.model.GithubRepo
import com.orcchg.direcall.util.Converter

class GithubRepoCloudConverter : Converter<GithubRepoEntity, GithubRepo> {

    override fun convert(from: GithubRepoEntity): GithubRepo =
        GithubRepo(
            name = from.name,
            size = from.size,
            url = from.url,
            defaultBranch = from.defaultBranch
        )
}
