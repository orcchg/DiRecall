package com.orcchg.direcall.feature.github_user_list.impl

import com.orcchg.direcall.feature.github_user_list.impl.presentation.ui.GithubUserListFragment
import com.orcchg.direcall.feature.github_user_list.pub.GithubUserListFeatureApi

interface GithubUserListFeatureInternalApi : GithubUserListFeatureApi {

    fun inject(target: GithubUserListFragment)
}
