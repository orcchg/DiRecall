package com.orcchg.direcall.feature.github_user_organizations.impl.domain.interactor

import com.orcchg.direcall.feature.github_user_organizations.api.interactor.GithubOrganizationInteractor
import com.orcchg.direcall.feature.github_user_organizations.api.model.GithubOrganization
import com.orcchg.direcall.feature.github_user_organizations.impl.domain.usecase.GetGithubOrganizationsUseCase
import io.reactivex.Single
import javax.inject.Inject

class GithubOrganizationInteractorImpl @Inject constructor(
    private val getGithubOrganizationsUseCase: GetGithubOrganizationsUseCase
) : GithubOrganizationInteractor {

    override fun organizations(login: String): Single<List<GithubOrganization>> =
        getGithubOrganizationsUseCase.source { "login" of login }
}
