package com.orcchg.direcall.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.orcchg.direcall.domain.model.GithubRepo
import com.orcchg.direcall.domain.usecase.GetGithubReposUseCase
import timber.log.Timber

class GithubRepoViewModel(
    private val login: String,
    private val getGithubReposUseCase: GetGithubReposUseCase
) : ViewModel()  {

    val repos: LiveData<List<GithubRepo>> by lazy(LazyThreadSafetyMode.NONE) {
        val liveData = MutableLiveData<List<GithubRepo>>()
        getGithubReposUseCase.source { "login" of login }
            .subscribe({ liveData.value = it }, Timber::e)
        liveData
    }
}
