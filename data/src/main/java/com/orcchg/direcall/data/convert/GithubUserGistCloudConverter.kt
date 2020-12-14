package com.orcchg.direcall.data.convert

import com.orcchg.direcall.data.model.GithubUserGistEntity
import com.orcchg.direcall.domain.model.GithubUserGist
import com.orcchg.direcall.util.Converter

class GithubUserGistCloudConverter : Converter<GithubUserGistEntity, GithubUserGist> {

    override fun convert(from: GithubUserGistEntity): GithubUserGist =
        GithubUserGist(
            description = from.description
        )
}