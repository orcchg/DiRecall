package com.orcchg.direcall.feature.githubrepo.impl.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.orcchg.direcall.core.analytics.api.Analytics
import com.orcchg.direcall.core.ui.BaseViewModel
import com.orcchg.direcall.feature.githubrepo.api.interactor.GithubRepoInteractor
import com.orcchg.direcall.feature.githubrepo.api.model.GithubRepo
import com.uber.autodispose.autoDispose
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Named

class GithubRepoViewModel @Inject constructor(
    @Named("login") private val login: String,
    private val analytics: Analytics,
    private val interactor: GithubRepoInteractor
) : BaseViewModel() {

    val repos: LiveData<List<GithubRepo>> by lazy(LazyThreadSafetyMode.NONE) {
        val liveData = MutableLiveData<List<GithubRepo>>()
        interactor.repos(login)
            .doOnSubscribe { analytics.sendEvent("get_repos", "Get list of repositories for github user $login") }
            .autoDispose(this)
            .subscribe({ liveData.value = it }, Timber::e)
        liveData
    }
}
