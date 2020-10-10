package com.orcchg.direcall.feature.githubuserdetails.impl.model.data

import com.squareup.moshi.Json

data class GithubUserDetailsEntity(
    @Json(name = "id") val id: Int,
    @Json(name = "login") val login: String,
    @Json(name = "url") val url: String?,
    @Json(name = "avatar_url") val avatarUrl: String?,
    @Json(name = "repos_url") val reposUrl: String?
)
