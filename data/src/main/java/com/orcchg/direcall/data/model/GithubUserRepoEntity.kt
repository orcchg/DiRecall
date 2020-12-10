package com.orcchg.direcall.data.model

import com.squareup.moshi.Json

data class GithubUserRepoEntity(
    @Json(name = "name") val name: String,
    @Json(name = "html_url") val htmlUrl: String,
    @Json(name = "size") val size: Int,
    @Json(name = "default_branch") val defaultBranch: String
)