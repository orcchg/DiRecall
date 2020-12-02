package com.orcchg.direcall.domain.usecase

import com.orcchg.direcall.base.Params
import com.orcchg.direcall.base.SchedulersFactory
import com.orcchg.direcall.base.usecase.SingleUseCase
import com.orcchg.direcall.domain.model.GithubUser
import com.orcchg.direcall.domain.repository.GithubRepository
import io.reactivex.Single

class GetGithubUsersUseCase(
    private val repository: GithubRepository,
    schedulersFactory: SchedulersFactory
) : SingleUseCase<List<GithubUser>>(schedulersFactory) {

    override fun sourceImpl(params: Params): Single<List<GithubUser>> =
        repository.users()
}
