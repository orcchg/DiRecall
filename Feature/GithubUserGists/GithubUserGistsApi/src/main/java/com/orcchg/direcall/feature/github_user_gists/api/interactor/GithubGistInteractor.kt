package com.orcchg.direcall.feature.github_user_gists.api.interactor

import com.orcchg.direcall.feature.github_user_gists.api.model.GithubGist
import io.reactivex.Single

interface GithubGistInteractor {

    fun gists(login: String): Single<List<GithubGist>>
}
