package com.orcchg.direcall.feature.github_user_organizations.impl.model.data

import com.squareup.moshi.Json

data class GithubOrganizationEntity(
    @Json(name = "id") val id: Int,
    @Json(name = "description") val description: String?,
    @Json(name = "url") val url: String?,
    @Json(name = "avatar_url") val avatarUrl: String?
)
