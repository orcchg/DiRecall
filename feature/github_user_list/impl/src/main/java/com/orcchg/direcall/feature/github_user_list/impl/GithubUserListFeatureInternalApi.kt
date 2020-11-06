package com.orcchg.direcall.feature.github_user_list.impl

import com.orcchg.direcall.feature.github_user_list.impl.presentation.ui.GithubUserListFragment
import com.orcchg.direcall.feature.github_user_list.pub.GithubUserListFeatureApi
import com.orcchg.direcall.feature.github_user_list.pub.GithubUserListFeatureScope
import com.squareup.anvil.annotations.ContributesTo

@ContributesTo(GithubUserListFeatureScope::class)
interface GithubUserListFeatureInternalApi : GithubUserListFeatureApi {

    fun inject(target: GithubUserListFragment)
}
