package com.orcchg.direcall.feature.githubrepo.impl.domain.interactor

import com.orcchg.direcall.feature.githubrepo.api.interactor.GithubRepoInteractor
import com.orcchg.direcall.feature.githubrepo.api.model.GithubRepo
import com.orcchg.direcall.feature.githubrepo.impl.domain.usecase.GetGithubReposUseCase
import io.reactivex.Single
import javax.inject.Inject

class GithubRepoInteractorImpl @Inject constructor(
    private val getGithubReposUseCase: GetGithubReposUseCase
) : GithubRepoInteractor {

    override fun repos(login: String): Single<List<GithubRepo>> =
        getGithubReposUseCase.source { "login" of login }
}
