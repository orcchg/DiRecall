package com.orcchg.direcall.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.orcchg.direcall.App
import com.orcchg.direcall.androidutil.AutoDisposeViewModel
import com.orcchg.direcall.domain.model.GithubRepo
import com.orcchg.direcall.domain.usecase.GetGithubUserRepoUseCase
import com.uber.autodispose.autoDispose
import timber.log.Timber

class GithubUserReposViewModel(
    private val login: String,
    private val app: App
) : AutoDisposeViewModel() {

    val userReposList: LiveData<List<GithubRepo>> by lazy(LazyThreadSafetyMode.NONE) {
        val liveData = MutableLiveData<List<GithubRepo>>()
        val useCase = app.serviceLokator[GetGithubUserRepoUseCase::class.java] as GetGithubUserRepoUseCase
        useCase.source { "login" of login }
            .autoDispose(this)
            .subscribe({ liveData.value = it }, Timber::e)
        liveData
    }
}