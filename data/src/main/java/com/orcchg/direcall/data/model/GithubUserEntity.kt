package com.orcchg.direcall.data.model

import com.squareup.moshi.Json

data class GithubUserEntity(
    @Json(name = "login") val login: String,
    @Json(name = "url") val url: String?,
    @Json(name = "avatar_url") val avatarUrl: String?
)

