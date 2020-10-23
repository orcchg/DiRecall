package com.orcchg.direcall.feature.github_repo.impl.domain.interactor

import com.orcchg.direcall.feature.github_repo.impl.domain.usecase.GetGithubReposUseCase
import com.orcchg.direcall.feature.github_repo.pub.domain.interactor.GithubRepoInteractor
import com.orcchg.direcall.feature.github_repo.pub.model.GithubRepo
import io.reactivex.Single
import javax.inject.Inject

class GithubRepoInteractorImpl @Inject constructor(
    private val getGithubReposUseCase: GetGithubReposUseCase
) : GithubRepoInteractor {

    override fun repos(login: String): Single<List<GithubRepo>> =
        getGithubReposUseCase.source { "login" of login }
}
