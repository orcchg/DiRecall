package com.orcchg.direcall.feature.github_repo.impl.data.repository

import com.orcchg.direcall.feature.github_repo.pub.model.GithubRepo
import io.reactivex.Single

interface GithubRepoRepository {

    fun repos(login: String): Single<List<GithubRepo>>
}
