package com.orcchg.direcall.feature.githubuserdetails.impl.domain.interactor

import com.orcchg.direcall.feature.githubuserdetails.api.domain.interactor.GithubUserDetailsInteractor
import com.orcchg.direcall.feature.githubuserdetails.api.domain.model.GithubUserDetails
import com.orcchg.direcall.feature.githubuserdetails.impl.domain.usecase.GetGithubUserDetailsUseCase
import io.reactivex.Single
import javax.inject.Inject

class GithubUserDetailsInteractorImpl @Inject constructor(
    private val getGithubUserDetailsUseCase: GetGithubUserDetailsUseCase
) : GithubUserDetailsInteractor {

    override fun user(login: String): Single<GithubUserDetails> =
        getGithubUserDetailsUseCase.source { "login" of login }
}
