package com.orcchg.direcall.feature.github_repo.impl.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.orcchg.direcall.core.ui.AutoDisposeViewModel
import com.orcchg.direcall.feature.github_repo.pub.domain.interactor.GithubRepoInteractor
import com.orcchg.direcall.feature.github_repo.pub.model.GithubRepo
import com.uber.autodispose.autoDispose
import timber.log.Timber
import javax.inject.Inject

class GithubRepoViewModel @Inject constructor(
    private val interactor: GithubRepoInteractor
) : AutoDisposeViewModel() {

    private val _repos = MutableLiveData<List<GithubRepo>>()
    internal val repos: LiveData<List<GithubRepo>> = _repos

    fun getRepos(login: String) {
        interactor.repos(login)
            .autoDispose(this)
            .subscribe({ _repos.value = it }, Timber::e)
    }
}
