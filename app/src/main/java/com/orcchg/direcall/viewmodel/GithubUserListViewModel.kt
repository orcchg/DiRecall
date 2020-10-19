package com.orcchg.direcall.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.orcchg.direcall.androidutil.AutoDisposeViewModel
import com.orcchg.direcall.domain.model.GithubUser
import com.orcchg.direcall.domain.usecase.GetGithubUsersUseCase
import com.uber.autodispose.autoDispose
import timber.log.Timber

class GithubUserListViewModel @ViewModelInject constructor(
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
