package com.orcchg.direcall.feature.github_user_gists.impl.data.remote

import com.orcchg.direcall.feature.github_user_gists.impl.model.data.GithubGistEntity
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubGistCloudRest {

    @GET("users/{login}/gists")
    fun gists(@Path("login") login: String): Single<List<GithubGistEntity>>
}
