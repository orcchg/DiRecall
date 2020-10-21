package com.orcchg.direcall.feature.github_user_organizations.impl.data.repository

import com.orcchg.direcall.feature.github_user_organizations.api.model.GithubOrganization
import io.reactivex.Single

interface GithubOrganizationRepository {

    fun organizations(login: String): Single<List<GithubOrganization>>
}
