package com.orcchg.direcall.feature.github_repo.impl.data.repository

import com.orcchg.direcall.feature.github_repo.impl.data.convert.GithubRepoCloudConverter
import com.orcchg.direcall.feature.github_repo.impl.data.remote.GithubRepoCloudRest
import com.orcchg.direcall.feature.github_repo.pub.model.GithubRepo
import io.reactivex.Single
import javax.inject.Inject

class GithubRepoRepositoryImpl @Inject constructor(
    private val cloud: GithubRepoCloudRest,
    private val converter: GithubRepoCloudConverter
) : GithubRepoRepository {

    override fun repos(login: String): Single<List<GithubRepo>> =
        cloud.repos(login).map(converter::convertList)
}
