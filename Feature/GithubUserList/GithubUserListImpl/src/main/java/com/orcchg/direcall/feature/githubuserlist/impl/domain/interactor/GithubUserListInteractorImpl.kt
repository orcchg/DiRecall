package com.orcchg.direcall.feature.githubuserlist.impl.domain.interactor

import com.orcchg.direcall.feature.githubuserlist.api.domain.interactor.GithubUserListInteractor
import com.orcchg.direcall.feature.githubuserlist.api.domain.model.GithubUser
import com.orcchg.direcall.feature.githubuserlist.impl.domain.usecase.GetGithubUsersUseCase
import io.reactivex.Single
import javax.inject.Inject

class GithubUserListInteractorImpl @Inject constructor(
    private val getGithubUsersUseCase: GetGithubUsersUseCase
) : GithubUserListInteractor {

    override fun users(): Single<List<GithubUser>> =
        getGithubUsersUseCase.source()
}
