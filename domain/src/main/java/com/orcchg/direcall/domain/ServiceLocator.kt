package com.orcchg.direcall.domain

import com.orcchg.direcall.domain.usecase.GetGithubReposUseCase
import com.orcchg.direcall.domain.usecase.GetGithubUserDetailsUseCase
import com.orcchg.direcall.domain.usecase.GetGithubUsersUseCase

interface ServiceLocator {

    val githubReposUseCase: GetGithubReposUseCase

    val githubUserDetailsUseCase: GetGithubUserDetailsUseCase

    val githubUsersUseCase: GetGithubUsersUseCase
}
