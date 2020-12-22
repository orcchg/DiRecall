package com.orcchg.direcall.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.orcchg.direcall.App
import com.orcchg.direcall.androidutil.AutoDisposeViewModel
import com.orcchg.direcall.domain.model.GithubUserOrg
import com.orcchg.direcall.domain.usecase.GetGithubUserOrgsUseCase
import com.uber.autodispose.autoDispose
import timber.log.Timber

class GithubUserOrgsListViewModel(
    private val login: String,
    private val app: App
) : AutoDisposeViewModel() {

    val orgsList: LiveData<List<GithubUserOrg>> by lazy(LazyThreadSafetyMode.NONE) {
        val liveData = MutableLiveData<List<GithubUserOrg>>()
        val useCase = app.serviceLokator[GetGithubUserOrgsUseCase::class.java] as GetGithubUserOrgsUseCase
        useCase.source { "login" of login }
            .autoDispose(this)
            .subscribe({ liveData.value = it }, Timber::e)
        liveData
    }
}