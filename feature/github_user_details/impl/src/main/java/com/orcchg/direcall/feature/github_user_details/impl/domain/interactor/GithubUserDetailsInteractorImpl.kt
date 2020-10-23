package com.orcchg.direcall.feature.github_user_details.impl.domain.interactor

import com.orcchg.direcall.feature.github_user_details.impl.domain.usecase.GetGithubUserDetailsUseCase
import com.orcchg.direcall.feature.github_user_details.pub.domain.interactor.GithubUserDetailsInteractor
import com.orcchg.direcall.feature.github_user_details.pub.model.GithubUserDetails
import io.reactivex.Single
import javax.inject.Inject

class GithubUserDetailsInteractorImpl @Inject constructor(
    private val getGithubUserDetailsUseCase: GetGithubUserDetailsUseCase
) : GithubUserDetailsInteractor {

    override fun user(login: String): Single<GithubUserDetails> =
        getGithubUserDetailsUseCase.source { "login" of login }
}
