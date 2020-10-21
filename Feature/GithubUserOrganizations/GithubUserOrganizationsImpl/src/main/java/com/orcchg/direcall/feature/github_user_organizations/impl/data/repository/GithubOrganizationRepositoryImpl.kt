package com.orcchg.direcall.feature.github_user_organizations.impl.data.repository

import com.orcchg.direcall.feature.github_user_organizations.api.model.GithubOrganization
import com.orcchg.direcall.feature.github_user_organizations.impl.data.convert.GithubOrganizationCloudConverter
import com.orcchg.direcall.feature.github_user_organizations.impl.data.remote.GithubOrganizationCloudRest
import io.reactivex.Single
import javax.inject.Inject

class GithubOrganizationRepositoryImpl @Inject constructor(
    private val cloud: GithubOrganizationCloudRest,
    private val organizationConverter: GithubOrganizationCloudConverter
) : GithubOrganizationRepository {

    override fun organizations(login: String): Single<List<GithubOrganization>> =
        cloud.organizations(login).map(organizationConverter::convertList)
}
