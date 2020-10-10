package com.orcchg.direcall.feature.githubrepo.impl.data.repository

import com.orcchg.direcall.feature.githubrepo.api.model.GithubRepo
import com.orcchg.direcall.feature.githubrepo.impl.data.convert.GithubRepoCloudConverter
import com.orcchg.direcall.feature.githubrepo.impl.data.remote.GithubRepoCloudRest
import io.reactivex.Single
import javax.inject.Inject

class GithubRepoRepositoryImpl @Inject constructor(
    private val cloud: GithubRepoCloudRest,
    private val repoConverter: GithubRepoCloudConverter
) : GithubRepoRepository {

    override fun repos(login: String): Single<List<GithubRepo>> =
        cloud.repos(login).map(repoConverter::convertList)
}
