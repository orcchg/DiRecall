package com.orcchg.direcall.feature.github_user_details.pub

import com.orcchg.direcall.feature.github_user_details.pub.domain.interactor.GithubUserDetailsInteractor

interface GithubUserDetailsFeatureApi {

    fun interactor(): GithubUserDetailsInteractor
}