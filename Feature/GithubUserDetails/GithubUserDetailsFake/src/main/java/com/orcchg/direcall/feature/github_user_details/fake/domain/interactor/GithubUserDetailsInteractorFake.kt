package com.orcchg.direcall.feature.github_user_details.fake.domain.interactor

import com.orcchg.direcall.feature.githubuserdetails.api.domain.interactor.GithubUserDetailsInteractor
import com.orcchg.direcall.feature.githubuserdetails.api.domain.model.GithubUserDetails
import io.reactivex.Single
import javax.inject.Inject

class GithubUserDetailsInteractorFake @Inject constructor() : GithubUserDetailsInteractor {

    override fun user(login: String): Single<GithubUserDetails> =
        Single.just(
            GithubUserDetails(
                login = "Maxim Alov Demo",
                url = "https://github.com/orcchg",
                avatarUrl = "https://avatars3.githubusercontent.com/u/1728123?s=460&u=c2aeab69a1ad1f36093b1250bfcfde44f955a917&v=4"
            )
        )
}
