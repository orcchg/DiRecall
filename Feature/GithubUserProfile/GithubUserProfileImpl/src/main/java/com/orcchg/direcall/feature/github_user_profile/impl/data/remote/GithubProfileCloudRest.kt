package com.orcchg.direcall.feature.github_user_profile.impl.data.remote

import com.orcchg.direcall.feature.github_user_profile.impl.model.data.GithubEventEntity
import com.orcchg.direcall.feature.github_user_profile.impl.model.data.GithubProjectEntity
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubProfileCloudRest {

    @GET("users/{login}/events/public")
    fun events(@Path("login") login: String): Single<List<GithubEventEntity>>

    @GET("users/{login}/projects")
    fun projects(@Path("login") login: String): Single<List<GithubProjectEntity>>
}
