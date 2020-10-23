package com.orcchg.direcall.feature.github_user_list.impl.domain.interactor

import com.orcchg.direcall.feature.github_user_list.impl.domain.usecase.GetGithubUsersUseCase
import com.orcchg.direcall.feature.github_user_list.pub.domain.interactor.GithubUserListInteractor
import com.orcchg.direcall.feature.github_user_list.pub.model.GithubUser
import io.reactivex.Single
import javax.inject.Inject

class GithubUserListInteractorImpl @Inject constructor(
    private val getGithubUsersUseCase: GetGithubUsersUseCase
) : GithubUserListInteractor {

    override fun users(): Single<List<GithubUser>> =
        getGithubUsersUseCase.source()
}
