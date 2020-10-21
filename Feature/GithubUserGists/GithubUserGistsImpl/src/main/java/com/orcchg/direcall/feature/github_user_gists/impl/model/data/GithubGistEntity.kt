package com.orcchg.direcall.feature.github_user_gists.impl.model.data

import com.squareup.moshi.Json

data class GithubGistEntity(
    @Json(name = "id") val id: String,
    @Json(name = "description") val description: String,
    @Json(name = "url") val url: String?
)
