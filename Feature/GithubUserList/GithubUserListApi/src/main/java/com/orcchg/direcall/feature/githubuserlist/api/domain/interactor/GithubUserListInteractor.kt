package com.orcchg.direcall.feature.githubuserlist.api.domain.interactor

import com.orcchg.direcall.feature.githubuserlist.api.domain.model.GithubUser
import io.reactivex.Single

interface GithubUserListInteractor {

    fun users(): Single<List<GithubUser>>
}
