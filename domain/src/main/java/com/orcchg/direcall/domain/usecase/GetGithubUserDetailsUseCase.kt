package com.orcchg.direcall.domain.usecase

import com.orcchg.direcall.base.Params
import com.orcchg.direcall.base.usecase.SingleUseCase
import com.orcchg.direcall.base.processSingle
import com.orcchg.direcall.core.scheduler.api.SchedulersFactory
import com.orcchg.direcall.domain.repository.GithubRepository
import com.orcchg.direcall.domain.model.GithubUserDetails
import io.reactivex.Single

class GetGithubUserDetailsUseCase(
    private val repository: GithubRepository,
    schedulersFactory: SchedulersFactory
) : SingleUseCase<GithubUserDetails>(schedulersFactory) {

    override fun sourceImpl(params: Params): Single<GithubUserDetails> =
        params.processSingle("login", repository::user)
}
