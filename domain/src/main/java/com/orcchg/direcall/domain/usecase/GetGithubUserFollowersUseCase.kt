package com.orcchg.direcall.domain.usecase

import com.orcchg.direcall.base.Params
import com.orcchg.direcall.base.SchedulersFactory
import com.orcchg.direcall.base.processSingle
import com.orcchg.direcall.base.usecase.SingleUseCase
import com.orcchg.direcall.domain.model.GithubUserFollower
import com.orcchg.direcall.domain.repository.GithubRepository
import io.reactivex.Single

class GetGithubUserFollowersUseCase(
    private val repository: GithubRepository,
    schedulersFactory: SchedulersFactory
) : SingleUseCase<List<GithubUserFollower>>(schedulersFactory) {

    override fun sourceImpl(params: Params): Single<List<GithubUserFollower>> =
        params.processSingle("login", repository::followers)
}