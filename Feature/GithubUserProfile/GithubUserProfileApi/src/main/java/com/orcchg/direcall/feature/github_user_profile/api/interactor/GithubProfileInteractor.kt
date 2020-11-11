package com.orcchg.direcall.feature.github_user_profile.api.interactor

import com.orcchg.direcall.feature.github_user_profile.api.model.GithubEvent
import com.orcchg.direcall.feature.github_user_profile.api.model.GithubProject
import io.reactivex.Single

interface GithubProfileInteractor {

    fun events(login: String): Single<List<GithubEvent>>

    fun projects(login: String): Single<List<GithubProject>>
}
