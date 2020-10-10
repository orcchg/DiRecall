package com.orcchg.direcall.feature.githubuserlist.impl.data.remote

import com.orcchg.direcall.feature.githubuserlist.impl.model.data.GithubUserEntity
import io.reactivex.Single
import retrofit2.http.GET

interface GithubUserListCloudRest {

    @GET("users")
    fun users(): Single<List<GithubUserEntity>>
}
