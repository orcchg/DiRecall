package com.orcchg.direcall.feature.github_user_profile.impl.model.data

import com.squareup.moshi.Json

data class GithubEventEntity(
    @Json(name = "id") val id: String,
    @Json(name = "type") val type: String
)
