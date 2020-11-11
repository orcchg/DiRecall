package com.orcchg.direcall.feature.github_user_profile.impl.data.repository

import com.orcchg.direcall.feature.github_user_profile.api.model.GithubEvent
import com.orcchg.direcall.feature.github_user_profile.api.model.GithubProject
import com.orcchg.direcall.feature.github_user_profile.impl.data.convert.GithubEventCloudConverter
import com.orcchg.direcall.feature.github_user_profile.impl.data.convert.GithubProjectCloudConverter
import com.orcchg.direcall.feature.github_user_profile.impl.data.remote.GithubProfileCloudRest
import io.reactivex.Single
import javax.inject.Inject

class GithubProfileRepositoryImpl @Inject constructor(
    private val cloud: GithubProfileCloudRest,
    private val eventConverter: GithubEventCloudConverter,
    private val projectConverter: GithubProjectCloudConverter
) : GithubProfileRepository {

    override fun events(login: String): Single<List<GithubEvent>> =
        cloud.events(login).map(eventConverter::convertList)

    override fun projects(login: String): Single<List<GithubProject>> =
        cloud.projects(login).map(projectConverter::convertList)
}
