package com.orcchg.direcall.feature.github_user_followers.impl.domain.interactor

import com.orcchg.direcall.feature.github_user_followers.api.interactor.GithubFollowerInteractor
import com.orcchg.direcall.feature.github_user_followers.api.model.GithubFollower
import com.orcchg.direcall.feature.github_user_followers.impl.domain.usecase.GetGithubFollowersUseCase
import io.reactivex.Single
import javax.inject.Inject

class GithubFollowerInteractorImpl @Inject constructor(
    private val getGithubFollowersUseCase: GetGithubFollowersUseCase
) : GithubFollowerInteractor {

    override fun followers(login: String): Single<List<GithubFollower>> =
        getGithubFollowersUseCase.source { "login" of login }
}
