package com.orcchg.direcall.feature.github_user_list.impl.data.remote

import com.orcchg.direcall.feature.github_user_list.impl.model.remote.GithubUserEntity
import io.reactivex.Single
import retrofit2.http.GET

interface GithubUserCloudRest {

    @GET("users")
    fun users(): Single<List<GithubUserEntity>>
}
