package com.orcchg.direcall.data.model

import com.squareup.moshi.Json

data class GithubUserGistEntity(
    @Json(name = "description") val description: String
)