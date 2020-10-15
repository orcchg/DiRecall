package com.orcchg.direcall.github_user_list.domain.usecase

import com.orcchg.direcall.base.Params
import com.orcchg.direcall.base.usecase.SingleUseCase
import com.orcchg.direcall.github_user_list.data.repository.GithubUserListRepository
import com.orcchg.direcall.github_user_list.domain.model.GithubUser
import com.orcchg.direcall.scheduler_api.SchedulersFactory
import io.reactivex.Single

class GetGithubUsersUseCase(
    private val repository: GithubUserListRepository,
    schedulersFactory: SchedulersFactory
) : SingleUseCase<List<GithubUser>>(schedulersFactory) {

    override fun sourceImpl(params: Params): Single<List<GithubUser>> =
        repository.users()
}
