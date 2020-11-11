package com.orcchg.direcall.feature.github_user_profile.impl.model.data

import com.squareup.moshi.Json

data class GithubProjectEntity(
    @Json(name = "id") val id: Int,
    @Json(name = "body") val brief: String,
    @Json(name = "name") val name: String
)
