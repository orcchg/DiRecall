package com.orcchg.direcall.feature.github_user_list.impl.data.repository

import com.orcchg.direcall.feature.github_user_list.impl.data.convert.GithubUserCloudConverter
import com.orcchg.direcall.feature.github_user_list.impl.data.remote.GithubUserCloudRest
import com.orcchg.direcall.feature.github_user_list.pub.model.GithubUser
import io.reactivex.Single
import javax.inject.Inject

class GithubUserListRepositoryImpl @Inject constructor(
    private val cloud: GithubUserCloudRest,
    private val converter: GithubUserCloudConverter
) : GithubUserListRepository {

    override fun users(): Single<List<GithubUser>> =
        cloud.users().map(converter::convertList)
}
