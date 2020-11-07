package com.orcchg.direcall.github_repo.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.orcchg.direcall.base.AssistedFactory
import com.orcchg.direcall.github_repo.domain.model.GithubRepo
import com.orcchg.direcall.github_repo.domain.usecase.GetGithubReposUseCase
import com.orcchg.direcall.ui_core_lib.AutoDisposeViewModel
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import com.uber.autodispose.autoDispose
import timber.log.Timber

class GithubRepoViewModel @AssistedInject constructor(
    private val getGithubReposUseCase: GetGithubReposUseCase,
    @Assisted private val login: String
) : AutoDisposeViewModel() {

    val repos: LiveData<List<GithubRepo>> by lazy(LazyThreadSafetyMode.NONE) {
        val liveData = MutableLiveData<List<GithubRepo>>()
        getGithubReposUseCase.source { "login" of login }
            .autoDispose(this)
            .subscribe({ liveData.value = it }, Timber::e)
        liveData
    }

    @AssistedInject.Factory
    interface RealAssistedFactory : AssistedFactory {
        fun create(login: String): GithubRepoViewModel
    }
}
