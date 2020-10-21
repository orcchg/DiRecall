package com.orcchg.direcall.feature.github_user_organizations.impl.data.convert

import com.orcchg.direcall.feature.github_user_organizations.api.model.GithubOrganization
import com.orcchg.direcall.feature.github_user_organizations.impl.model.data.GithubOrganizationEntity
import com.orcchg.direcall.util.Converter
import javax.inject.Inject

class GithubOrganizationCloudConverter @Inject constructor() : Converter<GithubOrganizationEntity, GithubOrganization> {

    override fun convert(from: GithubOrganizationEntity): GithubOrganization =
        GithubOrganization(
            id = from.id,
            description = from.description.orEmpty(),
            url = from.url,
            avatarUrl = from.avatarUrl
        )
}
