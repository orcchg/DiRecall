package com.orcchg.direcall.github_repo.di

interface GithubRepoFragmentComponentHolder {

    fun repoComponent(module: GithubRepoModule): GithubRepoFragmentComponent
}
