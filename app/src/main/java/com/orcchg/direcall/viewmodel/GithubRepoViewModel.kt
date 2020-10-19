package com.orcchg.direcall.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.orcchg.direcall.androidutil.AutoDisposeViewModel
import com.orcchg.direcall.domain.model.GithubRepo
import com.orcchg.direcall.domain.usecase.GetGithubReposUseCase
import com.uber.autodispose.autoDispose
import timber.log.Timber

class GithubRepoViewModel @ViewModelInject constructor(
    private val getGithubReposUseCase: GetGithubReposUseCase
) : AutoDisposeViewModel() {

    private val _repos = MutableLiveData<List<GithubRepo>>()
    val repos: LiveData<List<GithubRepo>> = _repos

    internal fun getRepos(login: String) {
        getGithubReposUseCase.source { "login" of login }
            .autoDispose(this)
            .subscribe({ _repos.value = it }, Timber::e)
    }
}
