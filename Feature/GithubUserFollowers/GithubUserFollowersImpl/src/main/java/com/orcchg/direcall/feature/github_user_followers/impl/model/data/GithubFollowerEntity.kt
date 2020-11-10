package com.orcchg.direcall.feature.github_user_followers.impl.model.data

import com.squareup.moshi.Json

data class GithubFollowerEntity(
    @Json(name = "id") val id: Int,
    @Json(name = "login") val login: String,
    @Json(name = "avatar_url") val avatarUrl: String?
)
