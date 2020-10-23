package com.orcchg.direcall.feature.github_user_details.impl.domain.usecase

import com.orcchg.direcall.base.Params
import com.orcchg.direcall.base.usecase.SingleUseCase
import com.orcchg.direcall.base.processSingle
import com.orcchg.direcall.core.scheduler.api.SchedulersFactory
import com.orcchg.direcall.feature.github_user_details.impl.data.repository.GithubUserDetailsRepository
import com.orcchg.direcall.feature.github_user_details.pub.model.GithubUserDetails
import io.reactivex.Single
import javax.inject.Inject

class GetGithubUserDetailsUseCase @Inject constructor(
    private val repository: GithubUserDetailsRepository,
    schedulersFactory: SchedulersFactory
) : SingleUseCase<GithubUserDetails>(schedulersFactory) {

    override fun sourceImpl(params: Params): Single<GithubUserDetails> =
        params.processSingle("login", repository::user)
}
