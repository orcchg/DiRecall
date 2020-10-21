package com.orcchg.direcall.feature.github_user_gists.impl.domain.interactor

import com.orcchg.direcall.feature.github_user_gists.api.interactor.GithubGistInteractor
import com.orcchg.direcall.feature.github_user_gists.api.model.GithubGist
import com.orcchg.direcall.feature.github_user_gists.impl.domain.usecase.GetGithubGistsUseCase
import io.reactivex.Single
import javax.inject.Inject

class GithubGistInteractorImpl @Inject constructor(
    private val getGithubGistsUseCase: GetGithubGistsUseCase
) : GithubGistInteractor {

    override fun gists(login: String): Single<List<GithubGist>> =
        getGithubGistsUseCase.source { "login" of login }
}
