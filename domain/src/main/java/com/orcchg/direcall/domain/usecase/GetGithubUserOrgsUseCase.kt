package com.orcchg.direcall.domain.usecase

import com.orcchg.direcall.base.Params
import com.orcchg.direcall.base.SchedulersFactory
import com.orcchg.direcall.base.processSingle
import com.orcchg.direcall.base.usecase.SingleUseCase
import com.orcchg.direcall.domain.model.GithubUserOrg
import com.orcchg.direcall.domain.repository.GithubRepository
import io.reactivex.Single
import javax.inject.Inject

class GetGithubUserOrgsUseCase @Inject constructor(
    private val repository: GithubRepository,
    schedulersFactory: SchedulersFactory
) : SingleUseCase<List<GithubUserOrg>>(schedulersFactory) {

    override fun sourceImpl(params: Params): Single<List<GithubUserOrg>> =
        params.processSingle("login", repository::organizations)
}