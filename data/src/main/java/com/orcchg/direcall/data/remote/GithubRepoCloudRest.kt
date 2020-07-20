package com.orcchg.direcall.data.remote

import com.orcchg.direcall.data.model.GithubRepoEntity
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubRepoCloudRest {

    @GET("users/{login}/repos")
    fun repos(@Path("login") login: String): Single<List<GithubRepoEntity>>
}
