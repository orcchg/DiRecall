package com.orcchg.direcall.feature.github_repo.impl

import com.orcchg.direcall.feature.github_repo.impl.presentation.ui.GithubRepoFragment
import com.orcchg.direcall.feature.github_repo.pub.GithubRepoFeatureApi

interface GithubRepoFeatureInternalApi : GithubRepoFeatureApi {

    fun inject(target: GithubRepoFragment)
}
