package com.orcchg.direcall.feature.github_user_gists.fake.domain.interactor

import com.orcchg.direcall.feature.github_user_gists.api.interactor.GithubGistInteractor
import com.orcchg.direcall.feature.github_user_gists.api.model.GithubGist
import io.reactivex.Single
import javax.inject.Inject

class GithubGistInteractorFake @Inject constructor() : GithubGistInteractor {

    override fun gists(login: String): Single<List<GithubGist>> =
        Single.just(listOf(
            GithubGist(id = "0", description = "demo gist 0", url = null),
            GithubGist(id = "1", description = "demo gist 1", url = null),
            GithubGist(id = "2", description = "demo gist 2", url = null),
            GithubGist(id = "3", description = "demo gist 3", url = null),
            GithubGist(id = "4", description = "demo gist 4", url = null)
        ))
}
