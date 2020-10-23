package com.orcchg.direcall.feature.github_repo.impl.domain.usecase

import com.orcchg.direcall.base.Params
import com.orcchg.direcall.base.processSingle
import com.orcchg.direcall.base.usecase.SingleUseCase
import com.orcchg.direcall.core.scheduler.api.SchedulersFactory
import com.orcchg.direcall.feature.github_repo.impl.data.repository.GithubRepoRepository
import com.orcchg.direcall.feature.github_repo.pub.model.GithubRepo
import io.reactivex.Single
import javax.inject.Inject

class GetGithubReposUseCase @Inject constructor(
    private val repository: GithubRepoRepository,
    schedulersFactory: SchedulersFactory
) : SingleUseCase<List<GithubRepo>>(schedulersFactory) {

    override fun sourceImpl(params: Params): Single<List<GithubRepo>> =
        params.processSingle("login", repository::repos)
}
