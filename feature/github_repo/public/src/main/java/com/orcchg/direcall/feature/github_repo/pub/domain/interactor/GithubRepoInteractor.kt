package com.orcchg.direcall.feature.github_repo.pub.domain.interactor

import com.orcchg.direcall.feature.github_repo.pub.model.GithubRepo
import io.reactivex.Single

interface GithubRepoInteractor {

    fun repos(login: String): Single<List<GithubRepo>>
}
