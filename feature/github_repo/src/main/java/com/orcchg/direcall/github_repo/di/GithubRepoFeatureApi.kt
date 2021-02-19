package com.orcchg.direcall.github_repo.di

import com.orcchg.direcall.github_repo.domain.interactor.GithubRepoInteractor
import com.orcchg.direcall.github_repo.presentation.ui.GithubRepoFragment

interface GithubRepoFeatureApi {
    fun interactor(): GithubRepoInteractor

    fun inject(target: GithubRepoFragment)
}
