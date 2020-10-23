package com.orcchg.direcall.feature.github_user_details.impl.data.remote

import com.orcchg.direcall.feature.github_user_details.impl.model.remote.GithubUserDetailsEntity
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubUserDetailsCloudRest {

    @GET("users/{login}")
    fun userDetails(@Path("login") login: String): Single<GithubUserDetailsEntity>
}
