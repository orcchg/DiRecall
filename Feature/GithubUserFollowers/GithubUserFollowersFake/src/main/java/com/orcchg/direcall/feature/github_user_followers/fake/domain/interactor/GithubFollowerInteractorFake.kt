package com.orcchg.direcall.feature.github_user_followers.fake.domain.interactor

import com.orcchg.direcall.feature.github_user_followers.api.interactor.GithubFollowerInteractor
import com.orcchg.direcall.feature.github_user_followers.api.model.GithubFollower
import io.reactivex.Single
import javax.inject.Inject

class GithubFollowerInteractorFake @Inject constructor() : GithubFollowerInteractor {

    override fun followers(login: String): Single<List<GithubFollower>> =
        Single.just(listOf(
            GithubFollower(id = 0, login = "demo follower 1", avatarUrl = "https://avatars1.githubusercontent.com/u/66577?s=460&v=4"),
            GithubFollower(id = 2, login = "demo follower 2", avatarUrl = "https://avatars2.githubusercontent.com/u/557033?s=460&u=e4b85cd6117b8912cd783f7152c32298794725f5&v=4"),
            GithubFollower(id = 3, login = "demo follower 3", avatarUrl = "https://avatars3.githubusercontent.com/u/133019?s=460&u=e74de21cd4a2948b635fcc48cf7b2f4957263915&v=4"),
            GithubFollower(id = 4, login = "demo follower 4", avatarUrl = "https://avatars3.githubusercontent.com/u/1075694?s=460&u=2acbe5ececcfbda35813e1e60022c77fcf5297d2&v=4")
        ))
}
