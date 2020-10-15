package com.orcchg.direcall.github_user_list.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.orcchg.direcall.ui_core_lib.AutoDisposeViewModel
import com.orcchg.direcall.github_user_list.domain.model.GithubUser
import com.orcchg.direcall.github_user_list.domain.usecase.GetGithubUsersUseCase
import com.uber.autodispose.autoDispose
import timber.log.Timber
import javax.inject.Inject

class GithubUserListViewModel @Inject constructor(
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
