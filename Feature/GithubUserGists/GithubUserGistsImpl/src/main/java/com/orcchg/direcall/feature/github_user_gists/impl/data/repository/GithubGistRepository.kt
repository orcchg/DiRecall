package com.orcchg.direcall.feature.github_user_gists.impl.data.repository

import com.orcchg.direcall.feature.github_user_gists.api.model.GithubGist
import io.reactivex.Single

interface GithubGistRepository {

    fun gists(login: String): Single<List<GithubGist>>
}
