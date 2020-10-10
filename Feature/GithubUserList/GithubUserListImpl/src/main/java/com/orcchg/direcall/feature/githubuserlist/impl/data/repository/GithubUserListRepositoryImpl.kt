package com.orcchg.direcall.feature.githubuserlist.impl.data.repository

import com.orcchg.direcall.feature.githubuserlist.api.domain.model.GithubUser
import com.orcchg.direcall.feature.githubuserlist.impl.data.convert.GithubUserCloudConverter
import com.orcchg.direcall.feature.githubuserlist.impl.data.remote.GithubUserListCloudRest
import io.reactivex.Single
import javax.inject.Inject

class GithubUserListRepositoryImpl @Inject constructor(
    private val cloud: GithubUserListCloudRest,
    private val userConverter: GithubUserCloudConverter
) : GithubUserListRepository {

    override fun users(): Single<List<GithubUser>> =
        cloud.users().map(userConverter::convertList)
}
