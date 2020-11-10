package com.orcchg.direcall.feature.github_user_followers.impl.data.remote

import com.orcchg.direcall.feature.github_user_followers.impl.model.data.GithubFollowerEntity
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubFollowerCloudRest {

    @GET("users/{login}/followers")
    fun followers(@Path("login") login: String): Single<List<GithubFollowerEntity>>
}
