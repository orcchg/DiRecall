package com.orcchg.direcall.feature.github_user_profile.impl.domain.interactor

import com.orcchg.direcall.feature.github_user_profile.api.interactor.GithubProfileInteractor
import com.orcchg.direcall.feature.github_user_profile.api.model.GithubEvent
import com.orcchg.direcall.feature.github_user_profile.api.model.GithubProject
import com.orcchg.direcall.feature.github_user_profile.impl.domain.usecase.GetGithubEventsUseCase
import com.orcchg.direcall.feature.github_user_profile.impl.domain.usecase.GetGithubProjectsUseCase
import io.reactivex.Single
import javax.inject.Inject

class GithubProfileInteractorImpl @Inject constructor(
    private val getGithubEventsUseCase: GetGithubEventsUseCase,
    private val getGithubProjectsUseCase: GetGithubProjectsUseCase
) : GithubProfileInteractor {

    override fun events(login: String): Single<List<GithubEvent>> =
        getGithubEventsUseCase.source { "login" of login }

    override fun projects(login: String): Single<List<GithubProject>> =
        getGithubProjectsUseCase.source { "login" of login }
}
