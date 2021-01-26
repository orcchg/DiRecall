package com.orcchg.direcall.data.convert

import com.orcchg.direcall.data.model.GithubUserGistEntity
import com.orcchg.direcall.domain.model.GithubUserGist
import com.orcchg.direcall.util.Converter
import javax.inject.Inject

class GithubUserGistCloudConverter @Inject constructor() :
    Converter<GithubUserGistEntity, GithubUserGist> {

    override fun convert(from: GithubUserGistEntity): GithubUserGist =
        GithubUserGist(
            description = from.description
        )
}