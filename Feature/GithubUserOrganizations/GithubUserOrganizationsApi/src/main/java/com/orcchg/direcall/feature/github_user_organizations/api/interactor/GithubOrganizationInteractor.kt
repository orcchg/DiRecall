package com.orcchg.direcall.feature.github_user_organizations.api.interactor

import com.orcchg.direcall.feature.github_user_organizations.api.model.GithubOrganization
import io.reactivex.Single

interface GithubOrganizationInteractor {

    fun organizations(login: String): Single<List<GithubOrganization>>
}
