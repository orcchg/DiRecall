package com.orcchg.direcall.feature.githubrepo.api.interactor

import com.orcchg.direcall.feature.githubrepo.api.model.GithubRepo
import io.reactivex.Single

interface GithubRepoInteractor {

    fun repos(login: String): Single<List<GithubRepo>>
}
