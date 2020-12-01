package com.orcchg.direcall.data.remote

import com.orcchg.direcall.data.model.GithubUserDetailsEntity
import com.orcchg.direcall.data.model.GithubUserEntity
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubUserCloudRest {

    @GET("users/{login}")
    fun userDetails(@Path("login") login: String): Single<GithubUserDetailsEntity>

    @GET("users")
    fun users(): Single<List<GithubUserEntity>>
}
