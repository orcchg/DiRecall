package com.orcchg.direcall.data.remote

import com.orcchg.direcall.data.model.GithubUserDetailsEntity
import com.orcchg.direcall.data.model.GithubUserEntity
import com.orcchg.direcall.data.model.GithubUserGistEntity
import com.orcchg.direcall.data.model.GithubUserRepoEntity
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
    fun userGist(@Path("login") login: String): Single<List<GithubUserGistEntity>>

    @GET("/users/{login}/followers")
    fun userFollowers(@Path("login") login: String): Single<List<GithubUserFollowersEntity>>
}
