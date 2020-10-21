package com.orcchg.direcall.feature.github_user_organizations.impl.domain.usecase

import com.orcchg.direcall.base.Params
import com.orcchg.direcall.base.processSingle
import com.orcchg.direcall.base.usecase.SingleUseCase
import com.orcchg.direcall.core.scheduler.api.SchedulersFactory
import com.orcchg.direcall.feature.github_user_organizations.api.model.GithubOrganization
import com.orcchg.direcall.feature.github_user_organizations.impl.data.repository.GithubOrganizationRepository
import io.reactivex.Single
import javax.inject.Inject

class GetGithubOrganizationsUseCase @Inject constructor(
    private val repository: GithubOrganizationRepository,
    schedulersFactory: SchedulersFactory
) : SingleUseCase<List<GithubOrganization>>(schedulersFactory) {

    override fun sourceImpl(params: Params): Single<List<GithubOrganization>> =
        params.processSingle("login", repository::organizations)
}
