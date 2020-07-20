package com.orcchg.direcall.domain.repository

import com.orcchg.direcall.domain.model.GithubRepo
import com.orcchg.direcall.domain.model.GithubUser
import com.orcchg.direcall.domain.model.GithubUserDetails
import io.reactivex.Single

interface GithubRepository {

    fun repos(login: String): Single<List<GithubRepo>>

    fun user(login: String): Single<GithubUserDetails>

    fun users(): Single<List<GithubUser>>
}
