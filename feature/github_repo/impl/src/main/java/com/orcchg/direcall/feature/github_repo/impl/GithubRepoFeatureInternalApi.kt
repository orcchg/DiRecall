package com.orcchg.direcall.feature.github_repo.impl

import com.orcchg.direcall.feature.github_repo.impl.presentation.ui.GithubRepoFragment
import com.orcchg.direcall.feature.github_repo.pub.GithubRepoFeatureApi
import com.orcchg.direcall.feature.github_repo.pub.GithubRepoFeatureScope
import com.squareup.anvil.annotations.ContributesTo

@ContributesTo(GithubRepoFeatureScope::class)
interface GithubRepoFeatureInternalApi : GithubRepoFeatureApi {

    fun inject(target: GithubRepoFragment)
}
