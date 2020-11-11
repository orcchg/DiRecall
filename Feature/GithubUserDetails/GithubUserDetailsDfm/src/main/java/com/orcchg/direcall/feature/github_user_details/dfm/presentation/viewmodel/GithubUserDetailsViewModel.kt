package com.orcchg.direcall.feature.github_user_details.dfm.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.orcchg.direcall.core.analytics.api.Analytics
import com.orcchg.direcall.core.ui.AutoDisposeViewModel
import com.orcchg.direcall.feature.githubuserdetails.api.domain.interactor.GithubUserDetailsInteractor
import com.orcchg.direcall.feature.githubuserdetails.api.domain.model.GithubUserDetails
import com.uber.autodispose.autoDispose
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Named

class GithubUserDetailsViewModel @Inject constructor(
    @Named("login") private val login: String,
    private val analytics: Analytics,
    private val interactor: GithubUserDetailsInteractor
) : AutoDisposeViewModel() {

    val user: LiveData<GithubUserDetails> by lazy(LazyThreadSafetyMode.NONE) {
        val liveData = MutableLiveData<GithubUserDetails>()
        interactor.user(login)
            .doOnSubscribe { analytics.sendEvent("get_user_details", "Get details for github user $login") }
            .autoDispose(this)
            .subscribe({ liveData.value = it }, Timber::e)
        liveData
    }
}
