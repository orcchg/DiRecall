package com.orcchg.direcall.data.di

import com.orcchg.direcall.domain.repository.GithubRepository

interface DataFeatureApi {

    fun repository(): GithubRepository
}
