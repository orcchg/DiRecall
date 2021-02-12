package com.orcchg.direcall.domain.usecase

import com.orcchg.direcall.base.Params
import com.orcchg.direcall.base.SchedulersFactory
import com.orcchg.direcall.base.processSingle
import com.orcchg.direcall.base.usecase.SingleUseCase
import com.orcchg.direcall.domain.repository.GithubRepository
import com.orcchg.direcall.domain.model.GithubRepo
import io.reactivex.Single
import javax.inject.Inject

class GetGithubReposUseCase @Inject constructor(
    private val repository: GithubRepository,
    schedulersFactory: SchedulersFactory
) : SingleUseCase<List<GithubRepo>>(schedulersFactory) {

    override fun sourceImpl(params: Params): Single<List<GithubRepo>> =
        params.processSingle("login", repository::repos)
}
