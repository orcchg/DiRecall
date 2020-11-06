package com.orcchg.direcall.feature.github_repo.pub

import com.orcchg.direcall.feature.github_repo.pub.domain.interactor.GithubRepoInteractor
import com.squareup.anvil.annotations.ContributesTo

@ContributesTo(GithubRepoFeatureScope::class)
interface GithubRepoFeatureApi {

    fun interactor(): GithubRepoInteractor
}
