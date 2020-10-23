package com.orcchg.direcall.feature.github_user_details.impl

import com.orcchg.direcall.feature.github_user_details.impl.presentation.ui.GithubUserDetailsFragment
import com.orcchg.direcall.feature.github_user_details.pub.GithubUserDetailsFeatureApi

interface GithubUserDetailsFeatureInternalApi : GithubUserDetailsFeatureApi {

    fun inject(target: GithubUserDetailsFragment)
}
