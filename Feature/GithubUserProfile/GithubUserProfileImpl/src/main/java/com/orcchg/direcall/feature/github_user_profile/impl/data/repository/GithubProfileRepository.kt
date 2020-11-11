package com.orcchg.direcall.feature.github_user_profile.impl.data.repository

import com.orcchg.direcall.feature.github_user_profile.api.model.GithubEvent
import com.orcchg.direcall.feature.github_user_profile.api.model.GithubProject
import io.reactivex.Single

interface GithubProfileRepository {

    fun events(login: String): Single<List<GithubEvent>>

    fun projects(login: String): Single<List<GithubProject>>
}
