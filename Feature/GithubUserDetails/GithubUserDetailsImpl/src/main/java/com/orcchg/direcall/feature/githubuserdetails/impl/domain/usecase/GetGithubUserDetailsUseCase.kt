package com.orcchg.direcall.feature.githubuserdetails.impl.domain.usecase

import com.orcchg.direcall.base.Params
import com.orcchg.direcall.base.SchedulersFactory
import com.orcchg.direcall.base.usecase.SingleUseCase
import com.orcchg.direcall.base.processSingle
import com.orcchg.direcall.feature.githubuserdetails.api.domain.model.GithubUserDetails
import com.orcchg.direcall.feature.githubuserdetails.impl.data.repository.GithubUserDetailsRepository
import io.reactivex.Single
import javax.inject.Inject

class GetGithubUserDetailsUseCase @Inject constructor(
    private val repository: GithubUserDetailsRepository,
    schedulersFactory: SchedulersFactory
) : SingleUseCase<GithubUserDetails>(schedulersFactory) {

    override fun sourceImpl(params: Params): Single<GithubUserDetails> =
        params.processSingle("login", repository::user)
}
