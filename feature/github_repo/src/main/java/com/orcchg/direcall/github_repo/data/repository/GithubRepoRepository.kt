package com.orcchg.direcall.github_repo.data.repository

import com.orcchg.direcall.github_repo.data.convert.GithubRepoCloudConverter
import com.orcchg.direcall.github_repo.data.remote.GithubRepoCloudRest
import com.orcchg.direcall.github_repo.domain.model.GithubRepo
import io.reactivex.Single
import javax.inject.Inject

class GithubRepoRepository @Inject constructor(
    private val repoCloud: GithubRepoCloudRest,
    private val repoConverter: GithubRepoCloudConverter
) {

    fun repos(login: String): Single<List<GithubRepo>> =
        repoCloud.repos(login).map(repoConverter::convertList)
}
