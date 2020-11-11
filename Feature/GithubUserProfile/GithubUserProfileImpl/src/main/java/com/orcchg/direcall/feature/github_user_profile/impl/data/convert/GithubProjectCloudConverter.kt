package com.orcchg.direcall.feature.github_user_profile.impl.data.convert

import com.orcchg.direcall.feature.github_user_profile.api.model.GithubProject
import com.orcchg.direcall.feature.github_user_profile.impl.model.data.GithubProjectEntity
import com.orcchg.direcall.util.Converter
import javax.inject.Inject

class GithubProjectCloudConverter @Inject constructor() : Converter<GithubProjectEntity, GithubProject> {

    override fun convert(from: GithubProjectEntity): GithubProject =
        GithubProject(
            id = from.id,
            brief = from.brief,
            name = from.name
        )
}
