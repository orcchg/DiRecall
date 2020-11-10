package com.orcchg.direcall.feature.github_user_followers.impl.domain.usecase

import com.orcchg.direcall.base.Params
import com.orcchg.direcall.base.processSingle
import com.orcchg.direcall.base.usecase.SingleUseCase
import com.orcchg.direcall.core.scheduler.api.SchedulersFactory
import com.orcchg.direcall.feature.github_user_followers.api.model.GithubFollower
import com.orcchg.direcall.feature.github_user_followers.impl.data.repository.GithubFollowerRepository
import io.reactivex.Single
import javax.inject.Inject

class GetGithubFollowersUseCase @Inject constructor(
    private val repository: GithubFollowerRepository,
    schedulersFactory: SchedulersFactory
) : SingleUseCase<List<GithubFollower>>(schedulersFactory) {

    override fun sourceImpl(params: Params): Single<List<GithubFollower>> =
        params.processSingle("login", repository::followers)
}
