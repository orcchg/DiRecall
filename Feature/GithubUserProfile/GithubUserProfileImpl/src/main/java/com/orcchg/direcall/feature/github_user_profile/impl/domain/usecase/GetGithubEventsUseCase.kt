package com.orcchg.direcall.feature.github_user_profile.impl.domain.usecase

import com.orcchg.direcall.base.Params
import com.orcchg.direcall.base.processSingle
import com.orcchg.direcall.base.usecase.SingleUseCase
import com.orcchg.direcall.core.scheduler.api.SchedulersFactory
import com.orcchg.direcall.feature.github_user_profile.api.model.GithubEvent
import com.orcchg.direcall.feature.github_user_profile.impl.data.repository.GithubProfileRepository
import io.reactivex.Single
import javax.inject.Inject

class GetGithubEventsUseCase @Inject constructor(
    private val repository: GithubProfileRepository,
    schedulersFactory: SchedulersFactory
) : SingleUseCase<List<GithubEvent>>(schedulersFactory) {

    override fun sourceImpl(params: Params): Single<List<GithubEvent>> =
        params.processSingle("login", repository::events)
}
