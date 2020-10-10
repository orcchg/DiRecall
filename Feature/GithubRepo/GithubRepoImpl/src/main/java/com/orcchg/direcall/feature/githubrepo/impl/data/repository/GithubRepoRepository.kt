package com.orcchg.direcall.feature.githubrepo.impl.data.repository

import com.orcchg.direcall.feature.githubrepo.api.model.GithubRepo
import io.reactivex.Single

interface GithubRepoRepository {

    fun repos(login: String): Single<List<GithubRepo>>
}
