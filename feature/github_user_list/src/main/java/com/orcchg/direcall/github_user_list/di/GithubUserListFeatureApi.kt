package com.orcchg.direcall.github_user_list.di

import com.orcchg.direcall.github_user_list.domain.interactor.GithubUserListInteractor
import com.orcchg.direcall.github_user_list.presentation.ui.GithubUserListFragment

interface GithubUserListFeatureApi {
    fun interactor(): GithubUserListInteractor

    fun inject(target: GithubUserListFragment)
}
