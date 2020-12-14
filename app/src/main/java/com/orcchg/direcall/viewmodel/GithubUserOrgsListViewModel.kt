package com.orcchg.direcall.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.orcchg.direcall.androidutil.AutoDisposeViewModel
import com.orcchg.direcall.domain.model.GithubUserOrg
import com.orcchg.direcall.domain.usecase.GetGithubUserOrgsUseCase
import com.uber.autodispose.autoDispose
import timber.log.Timber

class GithubUserOrgsListViewModel(
    private val login: String,
    private val getGithubUserOrgsUseCase: GetGithubUserOrgsUseCase
) : AutoDisposeViewModel() {

    val orgsList: LiveData<List<GithubUserOrg>> by lazy(LazyThreadSafetyMode.NONE) {
        val liveData = MutableLiveData<List<GithubUserOrg>>()
        getGithubUserOrgsUseCase.source { "login" of login }
            .autoDispose(this)
            .subscribe({ liveData.value = it }, Timber::e)
        liveData
    }
}