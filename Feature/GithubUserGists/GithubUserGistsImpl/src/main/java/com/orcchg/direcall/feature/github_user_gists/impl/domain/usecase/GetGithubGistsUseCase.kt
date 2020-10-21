package com.orcchg.direcall.feature.github_user_gists.impl.domain.usecase

import com.orcchg.direcall.base.Params
import com.orcchg.direcall.base.processSingle
import com.orcchg.direcall.base.usecase.SingleUseCase
import com.orcchg.direcall.core.scheduler.api.SchedulersFactory
import com.orcchg.direcall.feature.github_user_gists.api.model.GithubGist
import com.orcchg.direcall.feature.github_user_gists.impl.data.repository.GithubGistRepository
import io.reactivex.Single
import javax.inject.Inject

class GetGithubGistsUseCase @Inject constructor(
    private val repository: GithubGistRepository,
    schedulersFactory: SchedulersFactory
) : SingleUseCase<List<GithubGist>>(schedulersFactory) {

    override fun sourceImpl(params: Params): Single<List<GithubGist>> =
        params.processSingle("login", repository::gists)
}
