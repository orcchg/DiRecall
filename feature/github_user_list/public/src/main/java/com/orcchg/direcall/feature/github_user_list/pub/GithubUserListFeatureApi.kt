package com.orcchg.direcall.feature.github_user_list.pub

import com.orcchg.direcall.feature.github_user_list.pub.domain.interactor.GithubUserListInteractor

interface GithubUserListFeatureApi {

    fun interactor(): GithubUserListInteractor
}
