package com.orcchg.direcall.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.orcchg.direcall.androidutil.AutoDisposeViewModel
import com.orcchg.direcall.domain.model.GithubUserGist
import com.orcchg.direcall.domain.usecase.GetGithubUserGistUseCase
import com.uber.autodispose.autoDispose
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Named

class GithubUserGistListViewModel @Inject constructor(
    @Named("login") private val login: String,
    private val getGithubUserGistUseCase: GetGithubUserGistUseCase
) : AutoDisposeViewModel() {

    val gistList: LiveData<List<GithubUserGist>> by lazy(LazyThreadSafetyMode.NONE) {
        val liveData = MutableLiveData<List<GithubUserGist>>()
        getGithubUserGistUseCase.source{"login" of login}
            .autoDispose(this)
            .subscribe({ liveData.value = it }, Timber::e)
        liveData
    }
}