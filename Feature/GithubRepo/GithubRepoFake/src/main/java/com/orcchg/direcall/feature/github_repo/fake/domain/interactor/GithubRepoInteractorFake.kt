package com.orcchg.direcall.feature.github_repo.fake.domain.interactor

import com.orcchg.direcall.feature.githubrepo.api.interactor.GithubRepoInteractor
import com.orcchg.direcall.feature.githubrepo.api.model.GithubRepo
import io.reactivex.Single
import javax.inject.Inject

class GithubRepoInteractorFake @Inject constructor() : GithubRepoInteractor {

    override fun repos(login: String): Single<List<GithubRepo>> =
        Single.just(listOf(
            GithubRepo(name = "demo repository 0", size = 5, url = "https://github.com/orcchg/DiRecall", defaultBranch = "master"),
            GithubRepo(name = "demo repository 1", size = 5, url = "https://github.com/orcchg/DiRecall", defaultBranch = "master"),
            GithubRepo(name = "demo repository 2", size = 5, url = "https://github.com/orcchg/DiRecall", defaultBranch = "master")
        ))
}
