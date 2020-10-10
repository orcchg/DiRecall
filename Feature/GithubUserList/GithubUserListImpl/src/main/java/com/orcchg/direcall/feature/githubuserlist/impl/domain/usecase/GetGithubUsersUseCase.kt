package com.orcchg.direcall.feature.githubuserlist.impl.domain.usecase

import com.orcchg.direcall.base.Params
import com.orcchg.direcall.base.usecase.SingleUseCase
import com.orcchg.direcall.core.scheduler.api.SchedulersFactory
import com.orcchg.direcall.feature.githubuserlist.api.domain.model.GithubUser
import com.orcchg.direcall.feature.githubuserlist.impl.data.repository.GithubUserListRepository
import io.reactivex.Single
import javax.inject.Inject

class GetGithubUsersUseCase @Inject constructor(
    private val repository: GithubUserListRepository,
    schedulersFactory: SchedulersFactory
) : SingleUseCase<List<GithubUser>>(schedulersFactory) {

    override fun sourceImpl(params: Params): Single<List<GithubUser>> =
        repository.users()
}
