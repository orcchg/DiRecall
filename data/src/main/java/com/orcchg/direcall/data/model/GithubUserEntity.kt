package com.orcchg.direcall.data.model

import com.squareup.moshi.Json

data class GithubUserEntity(
    @Json(name = "id") val id: Int,
    @Json(name = "login") val login: String,
    @Json(name = "avatarUrl") val avatarUrl: String? = null
)
