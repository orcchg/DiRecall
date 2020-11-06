package com.orcchg.direcall.feature.github_user_details.impl

import com.orcchg.direcall.feature.github_user_details.impl.presentation.ui.GithubUserDetailsFragment
import com.orcchg.direcall.feature.github_user_details.pub.GithubUserDetailsFeatureApi
import com.orcchg.direcall.feature.github_user_details.pub.GithubUserDetailsFeatureScope
import com.squareup.anvil.annotations.ContributesTo

@ContributesTo(GithubUserDetailsFeatureScope::class)
interface GithubUserDetailsFeatureInternalApi : GithubUserDetailsFeatureApi {

    fun inject(target: GithubUserDetailsFragment)
}
