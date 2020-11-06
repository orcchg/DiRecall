package com.orcchg.direcall.feature.github_user_details.pub

import com.orcchg.direcall.feature.github_user_details.pub.domain.interactor.GithubUserDetailsInteractor
import com.squareup.anvil.annotations.ContributesTo

@ContributesTo(GithubUserDetailsFeatureScope::class)
interface GithubUserDetailsFeatureApi {

    fun interactor(): GithubUserDetailsInteractor
}