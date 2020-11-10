package com.orcchg.direcall.feature.github_user_followers.dfm.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.orcchg.direcall.core.analytics.api.Analytics
import com.orcchg.direcall.core.ui.AutoDisposeViewModel
import com.orcchg.direcall.feature.github_user_followers.api.interactor.GithubFollowerInteractor
import com.orcchg.direcall.feature.github_user_followers.api.model.GithubFollower
import com.uber.autodispose.autoDispose
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Named

class GithubUserFollowersViewModel @Inject constructor(
    @Named("login") private val login: String,
    private val analytics: Analytics,
    private val interactor: GithubFollowerInteractor
) : AutoDisposeViewModel() {

    val followers: LiveData<List<GithubFollower>> by lazy(LazyThreadSafetyMode.NONE) {
        val liveData = MutableLiveData<List<GithubFollower>>()
        interactor.followers(login)
            .doOnSubscribe { analytics.sendEvent("get_followers", "Get list of followers for github user $login") }
            .autoDispose(this)
            .subscribe({ liveData.value = it }, Timber::e)
        liveData
    }
}
