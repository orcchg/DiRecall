package com.orcchg.direcall.viewmodel

import com.orcchg.direcall.domain.model.GithubRepo
import com.orcchg.direcall.domain.usecase.GetGithubReposUseCase
import io.reactivex.Single

class GithubRepoViewModel(
    private val getGithubReposUseCase: GetGithubReposUseCase
) {

    fun repos(login: String): Single<List<GithubRepo>> =
        getGithubReposUseCase.source { "login" of login }
}
