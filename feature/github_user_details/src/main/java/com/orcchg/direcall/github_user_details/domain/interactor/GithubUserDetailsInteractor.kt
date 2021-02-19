package com.orcchg.direcall.github_user_details.domain.interactor

import com.orcchg.direcall.github_user_details.domain.model.GithubUserDetails
import com.orcchg.direcall.github_user_details.domain.usecase.GetGithubUserDetailsUseCase
import io.reactivex.Single
import javax.inject.Inject

class GithubUserDetailsInteractor @Inject constructor(
    private val getGithubUserDetailsUseCase: GetGithubUserDetailsUseCase
) {

    fun user(login: String): Single<GithubUserDetails> =
        getGithubUserDetailsUseCase.source { "login" of login }
}
