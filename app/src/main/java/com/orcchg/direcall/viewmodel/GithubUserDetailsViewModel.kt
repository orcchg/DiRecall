package com.orcchg.direcall.viewmodel

import com.orcchg.direcall.domain.model.GithubUserDetails
import com.orcchg.direcall.domain.usecase.GetGithubUserDetailsUseCase
import io.reactivex.Single

class GithubUserDetailsViewModel(
    private val getGithubUserDetailsUseCase: GetGithubUserDetailsUseCase
) {

    fun user(login: String): Single<GithubUserDetails> =
        getGithubUserDetailsUseCase.source { "login" of login }
}
