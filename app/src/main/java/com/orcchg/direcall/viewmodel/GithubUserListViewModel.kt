package com.orcchg.direcall.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.orcchg.direcall.core.ui.AutoDisposeViewModel
import com.orcchg.direcall.domain.model.GithubUser
import com.orcchg.direcall.domain.usecase.GetGithubUsersUseCase
import com.uber.autodispose.autoDispose
import timber.log.Timber

class GithubUserListViewModel(
    private val getGithubUsersUseCase: GetGithubUsersUseCase
) : AutoDisposeViewModel() {

    val users: LiveData<List<GithubUser>> by lazy(LazyThreadSafetyMode.NONE) {
        val liveData = MutableLiveData<List<GithubUser>>()
        getGithubUsersUseCase.source()
            .autoDispose(this)
            .subscribe({ liveData.value = it }, Timber::e)
        liveData
    }
}
