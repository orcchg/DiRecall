package com.orcchg.direcall.domain.repository

import com.orcchg.direcall.domain.model.*
import io.reactivex.Single

interface GithubRepository {

    fun repos(login: String): Single<List<GithubRepo>>

    fun user(login: String): Single<GithubUserDetails>

    fun users(): Single<List<GithubUser>>

    fun gists(login: String): Single<List<GithubUserGist>>

    fun followers(login: String): Single<List<GithubUserFollower>>

    fun organizations(login: String): Single<List<GithubUserOrg>>
}
