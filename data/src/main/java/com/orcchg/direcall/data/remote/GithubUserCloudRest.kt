package com.orcchg.direcall.data.remote

import com.orcchg.direcall.data.model.*
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubUserCloudRest {

    @GET("users/{login}")
    fun userDetails(@Path("login") login: String): Single<GithubUserDetailsEntity>

    @GET("users")
    fun users(): Single<List<GithubUserEntity>>

    @GET("/users/{login}/repos")
    fun repos(@Path("login") login: String): Single<List<GithubUserRepoEntity>>

    @GET("/users/{login}/gists")
    fun gists(@Path("login") login: String): Single<List<GithubUserGistEntity>>

    @GET("/users/{login}/followers")
    fun followers(@Path("login") login: String): Single<List<GithubUserFollowersEntity>>

    @GET("/users/{login}/orgs")
    fun organizations(@Path("login") login: String): Single<List<GithubUserOrgsEntity>>
}
