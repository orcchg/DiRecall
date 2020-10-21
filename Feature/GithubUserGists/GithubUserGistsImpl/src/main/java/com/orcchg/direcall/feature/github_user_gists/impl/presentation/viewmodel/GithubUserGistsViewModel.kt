package com.orcchg.direcall.feature.github_user_gists.impl.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.orcchg.direcall.core.ui.BaseViewModel
import com.orcchg.direcall.feature.github_user_gists.api.interactor.GithubGistInteractor
import com.orcchg.direcall.feature.github_user_gists.api.model.GithubGist
import com.uber.autodispose.autoDispose
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Named

class GithubUserGistsViewModel @Inject constructor(
    @Named("login") private val login: String,
    private val interactor: GithubGistInteractor
) : BaseViewModel() {

    val gists: LiveData<List<GithubGist>> by lazy(LazyThreadSafetyMode.NONE) {
        val liveData = MutableLiveData<List<GithubGist>>()
        interactor.gists(login)
            .autoDispose(this)
            .subscribe({ liveData.value = it }, Timber::e)
        liveData
    }
}
