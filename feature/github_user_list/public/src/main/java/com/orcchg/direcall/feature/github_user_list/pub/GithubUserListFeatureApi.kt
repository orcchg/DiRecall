package com.orcchg.direcall.feature.github_user_list.pub

import com.orcchg.direcall.feature.github_user_list.pub.domain.interactor.GithubUserListInteractor
import com.squareup.anvil.annotations.ContributesTo

@ContributesTo(GithubUserListFeatureScope::class)
interface GithubUserListFeatureApi {

    fun interactor(): GithubUserListInteractor
}
