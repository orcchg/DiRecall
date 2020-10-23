package com.orcchg.direcall.feature.github_user_list.impl.data.repository

import com.orcchg.direcall.feature.github_user_list.pub.model.GithubUser
import io.reactivex.Single

interface GithubUserListRepository {

    fun users(): Single<List<GithubUser>>
}
