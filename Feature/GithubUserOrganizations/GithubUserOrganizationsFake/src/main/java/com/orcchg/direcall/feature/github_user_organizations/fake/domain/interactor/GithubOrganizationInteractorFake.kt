package com.orcchg.direcall.feature.github_user_organizations.fake.domain.interactor

import com.orcchg.direcall.feature.github_user_organizations.api.interactor.GithubOrganizationInteractor
import com.orcchg.direcall.feature.github_user_organizations.api.model.GithubOrganization
import io.reactivex.Single
import javax.inject.Inject

class GithubOrganizationInteractorFake @Inject constructor() : GithubOrganizationInteractor {

    override fun organizations(login: String): Single<List<GithubOrganization>> =
        Single.just(listOf(
            GithubOrganization(id = 0, description = "demo org 1", url = null, avatarUrl = "https://avatars0.githubusercontent.com/u/82592?s=200&v=4"),
            GithubOrganization(id = 1, description = "demo org 2", url = null, avatarUrl = "https://avatars0.githubusercontent.com/u/82592?s=200&v=4"),
            GithubOrganization(id = 2, description = "demo org 3", url = null, avatarUrl = "https://avatars0.githubusercontent.com/u/82592?s=200&v=4")
        ))
}
