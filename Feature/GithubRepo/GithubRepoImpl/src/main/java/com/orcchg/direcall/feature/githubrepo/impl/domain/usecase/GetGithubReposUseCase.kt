package com.orcchg.direcall.feature.githubrepo.impl.domain.usecase

import com.orcchg.direcall.base.Params
import com.orcchg.direcall.base.processSingle
import com.orcchg.direcall.base.usecase.SingleUseCase
import com.orcchg.direcall.core.scheduler.api.SchedulersFactory
import com.orcchg.direcall.feature.githubrepo.api.model.GithubRepo
import com.orcchg.direcall.feature.githubrepo.impl.data.repository.GithubRepoRepository
import io.reactivex.Single
import javax.inject.Inject

class GetGithubReposUseCase @Inject constructor(
    private val repository: GithubRepoRepository,
    schedulersFactory: SchedulersFactory
) : SingleUseCase<List<GithubRepo>>(schedulersFactory) {

    override fun sourceImpl(params: Params): Single<List<GithubRepo>> =
        params.processSingle("login", repository::repos)
}
