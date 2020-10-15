package com.orcchg.direcall.github_user_list.data.repository

import com.orcchg.direcall.github_user_list.data.convert.GithubUserCloudConverter
import com.orcchg.direcall.github_user_list.data.remote.GithubUserListCloudRest
import com.orcchg.direcall.github_user_list.domain.model.GithubUser
import io.reactivex.Single

class GithubUserListRepository(
    private val userCloud: GithubUserListCloudRest,
    private val userConverter: GithubUserCloudConverter
) {

    fun users(): Single<List<GithubUser>> =
        userCloud.users().map(userConverter::convertList)
}
