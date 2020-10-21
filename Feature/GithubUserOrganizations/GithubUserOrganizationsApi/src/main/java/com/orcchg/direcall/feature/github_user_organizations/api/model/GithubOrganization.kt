package com.orcchg.direcall.feature.github_user_organizations.api.model

data class GithubOrganization(
    val id: Int,
    val description: String,
    val url: String?,
    val avatarUrl: String?
)
