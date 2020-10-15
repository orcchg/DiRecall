package com.orcchg.direcall.github_user_details.data.remote

import com.orcchg.direcall.github_user_details.data.model.GithubUserDetailsEntity
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubUserDetailsCloudRest {

    @GET("users/{login}")
    fun userDetails(@Path("login") login: String): Single<GithubUserDetailsEntity>
}
