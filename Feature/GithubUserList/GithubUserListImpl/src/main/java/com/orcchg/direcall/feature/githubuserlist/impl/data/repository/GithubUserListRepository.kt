package com.orcchg.direcall.feature.githubuserlist.impl.data.repository

import com.orcchg.direcall.feature.githubuserlist.api.domain.model.GithubUser
import io.reactivex.Single

interface GithubUserListRepository {

    fun users(): Single<List<GithubUser>>
}
