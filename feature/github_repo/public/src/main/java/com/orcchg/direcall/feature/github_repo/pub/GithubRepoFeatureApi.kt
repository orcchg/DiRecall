package com.orcchg.direcall.feature.github_repo.pub

import com.orcchg.direcall.feature.github_repo.pub.domain.interactor.GithubRepoInteractor

interface GithubRepoFeatureApi {

    fun interactor(): GithubRepoInteractor
}
