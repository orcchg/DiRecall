package com.orcchg.direcall.feature.github_user_list.pub.domain.interactor

import com.orcchg.direcall.feature.github_user_list.pub.model.GithubUser
import io.reactivex.Single

interface GithubUserListInteractor {

    fun users(): Single<List<GithubUser>>
}
