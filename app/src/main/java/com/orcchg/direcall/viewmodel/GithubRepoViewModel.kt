package com.orcchg.direcall.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.orcchg.direcall.androidutil.AutoDisposeViewModel
import com.orcchg.direcall.domain.model.GithubRepo
import com.orcchg.direcall.domain.usecase.GetGithubReposUseCase
import com.uber.autodispose.autoDispose
import timber.log.Timber
import javax.inject.Inject

class GithubRepoViewModel @Inject constructor(
    private val getGithubReposUseCase: GetGithubReposUseCase
) : AutoDisposeViewModel() {

    private lateinit var login: String

    internal fun setLogin(login: String) {
        this.login = login
    }

    val repos: LiveData<List<GithubRepo>> by lazy(LazyThreadSafetyMode.NONE) {
        val liveData = MutableLiveData<List<GithubRepo>>()
        getGithubReposUseCase.source { "login" of login }
            .autoDispose(this)
            .subscribe({ liveData.value = it }, Timber::e)
        liveData
    }
}
