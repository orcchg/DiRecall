package com.orcchg.direcall.feature.github_user_list.impl.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.orcchg.direcall.core.ui.AutoDisposeViewModel
import com.orcchg.direcall.feature.github_user_list.pub.domain.interactor.GithubUserListInteractor
import com.orcchg.direcall.feature.github_user_list.pub.model.GithubUser
import com.uber.autodispose.autoDispose
import timber.log.Timber
import javax.inject.Inject

class GithubUserListViewModel @Inject constructor(
    private val interactor: GithubUserListInteractor
) : AutoDisposeViewModel() {

    val users: LiveData<List<GithubUser>> by lazy(LazyThreadSafetyMode.NONE) {
        val liveData = MutableLiveData<List<GithubUser>>()
        interactor.users()
            .autoDispose(this)
            .subscribe({ liveData.value = it }, Timber::e)
        liveData
    }
}
