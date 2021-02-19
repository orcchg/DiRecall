package com.orcchg.direcall.github_user_list.domain.interactor

import com.orcchg.direcall.github_user_list.domain.model.GithubUser
import com.orcchg.direcall.github_user_list.domain.usecase.GetGithubUsersUseCase
import io.reactivex.Single
import javax.inject.Inject

class GithubUserListInteractor @Inject constructor(
    private val getGithubUsersUseCase: GetGithubUsersUseCase
) {

    fun users(): Single<List<GithubUser>> = getGithubUsersUseCase.source()
}
