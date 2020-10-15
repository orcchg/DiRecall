package com.orcchg.direcall.github_user_list.data.remote

import com.orcchg.direcall.github_user_list.data.model.GithubUserEntity
import io.reactivex.Single
import retrofit2.http.GET

interface GithubUserListCloudRest {

    @GET("users")
    fun users(): Single<List<GithubUserEntity>>
}
