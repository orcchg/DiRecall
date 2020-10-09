package com.orcchg.direcall.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.orcchg.direcall.androidutil.AutoDisposeViewModel
import com.orcchg.direcall.domain.model.GithubRepo
import com.orcchg.direcall.domain.usecase.GetGithubReposUseCase
import com.uber.autodispose.autoDispose
import timber.log.Timber

class GithubRepoViewModel(
    private val login: String,
    private val getGithubReposUseCase: GetGithubReposUseCase
) : AutoDisposeViewModel() {

    val repos: LiveData<List<GithubRepo>> by lazy(LazyThreadSafetyMode.NONE) {
        val liveData = MutableLiveData<List<GithubRepo>>()
        getGithubReposUseCase.source { "login" of login }
            .autoDispose(this)
            .subscribe({ liveData.value = it }, Timber::e)
        liveData
    }
}
