package com.orcchg.direcall.github_repo.domain.usecase

import com.orcchg.direcall.base.Params
import com.orcchg.direcall.base.processSingle
import com.orcchg.direcall.base.usecase.SingleUseCase
import com.orcchg.direcall.github_repo.data.repository.GithubRepoRepository
import com.orcchg.direcall.github_repo.domain.model.GithubRepo
import com.orcchg.direcall.scheduler_api.SchedulersFactory
import io.reactivex.Single

class GetGithubReposUseCase(
    private val repository: GithubRepoRepository,
    schedulersFactory: SchedulersFactory
) : SingleUseCase<List<GithubRepo>>(schedulersFactory) {

    override fun sourceImpl(params: Params): Single<List<GithubRepo>> =
        params.processSingle("login", repository::repos)
}
