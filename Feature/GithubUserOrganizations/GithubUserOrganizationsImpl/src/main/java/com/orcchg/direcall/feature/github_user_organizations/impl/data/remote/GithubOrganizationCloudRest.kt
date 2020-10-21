package com.orcchg.direcall.feature.github_user_organizations.impl.data.remote

import com.orcchg.direcall.feature.github_user_organizations.impl.model.data.GithubOrganizationEntity
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubOrganizationCloudRest {

    @GET("users/{login}/orgs")
    fun organizations(@Path("login") login: String): Single<List<GithubOrganizationEntity>>
}
