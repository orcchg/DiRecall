package com.orcchg.direcall.feature.github_user_gists.impl.data.repository

import com.orcchg.direcall.feature.github_user_gists.api.model.GithubGist
import com.orcchg.direcall.feature.github_user_gists.impl.data.convert.GithubGistCloudConverter
import com.orcchg.direcall.feature.github_user_gists.impl.data.remote.GithubGistCloudRest
import io.reactivex.Single
import javax.inject.Inject

class GithubGistRepositoryImpl @Inject constructor(
    private val cloud: GithubGistCloudRest,
    private val gistConverter: GithubGistCloudConverter
) : GithubGistRepository {

    override fun gists(login: String): Single<List<GithubGist>> =
        cloud.gists(login).map(gistConverter::convertList)
}
