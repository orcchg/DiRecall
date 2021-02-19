package com.orcchg.direcall.github_user_details.di

import com.orcchg.direcall.github_user_details.domain.interactor.GithubUserDetailsInteractor
import com.orcchg.direcall.github_user_details.presentation.ui.GithubUserDetailsFragment

interface GithubUserDetailsFeatureApi {
    fun interactor(): GithubUserDetailsInteractor

    fun inject(target: GithubUserDetailsFragment)
}
