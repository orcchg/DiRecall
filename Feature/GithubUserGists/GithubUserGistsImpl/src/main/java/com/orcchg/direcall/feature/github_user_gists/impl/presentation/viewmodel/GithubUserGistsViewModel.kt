package com.orcchg.direcall.feature.github_user_gists.impl.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.orcchg.direcall.core.analytics.api.Analytics
import com.orcchg.direcall.core.di.FeatureContainer
import com.orcchg.direcall.core.ui.AutoDisposeViewModel
import com.orcchg.direcall.core.ui.BaseViewModel
import com.orcchg.direcall.feature.github_user_gists.api.interactor.GithubGistInteractor
import com.orcchg.direcall.feature.github_user_gists.api.model.GithubGist
import com.orcchg.direcall.feature.github_user_gists.impl.di.GistLogin
import com.uber.autodispose.autoDispose
import timber.log.Timber
import javax.inject.Inject

/**
 * This [ViewModel] of a dynamic feature cannot extend [BaseViewModel] since the latter contains
 * some lateinit properties that are tightly coupled with [FeatureContainer] which does not contain
 * any binding from this (and any other) dynamic feature.
 */
class GithubUserGistsViewModel @Inject constructor(
    @GistLogin private val login: String,
    private val analytics: Analytics,
    private val interactor: GithubGistInteractor
) : AutoDisposeViewModel() {

    val gists: LiveData<List<GithubGist>> by lazy(LazyThreadSafetyMode.NONE) {
        val liveData = MutableLiveData<List<GithubGist>>()
        interactor.gists(login)
            .doOnSubscribe { analytics.sendEvent("get_gists", "Get list of gists for github user $login") }
            .autoDispose(this)
            .subscribe({ liveData.value = it }, Timber::e)
        liveData
    }
}
