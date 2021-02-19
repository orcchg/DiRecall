package com.orcchg.direcall.github_repo.domain.interactor

import com.orcchg.direcall.github_repo.domain.model.GithubRepo
import com.orcchg.direcall.github_repo.domain.usecase.GetGithubReposUseCase
import io.reactivex.Single
import javax.inject.Inject

class GithubRepoInteractor @Inject constructor(
    private val getGithubReposUseCase: GetGithubReposUseCase
) {

    fun repos(login: String): Single<List<GithubRepo>> =
        getGithubReposUseCase.source { "login" of login }
}
