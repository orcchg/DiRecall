package com.orcchg.direcall.feature.githubuserlist.impl.model.data

import com.squareup.moshi.Json

data class GithubUserEntity(
    @Json(name = "id") val id: Int,
    @Json(name = "login") val login: String,
    @Json(name = "avatar_url") val avatarUrl: String? = null
)
