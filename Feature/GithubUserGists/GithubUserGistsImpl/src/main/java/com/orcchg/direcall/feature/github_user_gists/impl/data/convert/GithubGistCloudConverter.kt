package com.orcchg.direcall.feature.github_user_gists.impl.data.convert

import com.orcchg.direcall.feature.github_user_gists.api.model.GithubGist
import com.orcchg.direcall.feature.github_user_gists.impl.model.data.GithubGistEntity
import com.orcchg.direcall.util.Converter
import javax.inject.Inject

class GithubGistCloudConverter @Inject constructor() : Converter<GithubGistEntity, GithubGist> {

    override fun convert(from: GithubGistEntity): GithubGist =
        GithubGist(
            id = from.id,
            description = from.description,
            url = from.url
        )
}
