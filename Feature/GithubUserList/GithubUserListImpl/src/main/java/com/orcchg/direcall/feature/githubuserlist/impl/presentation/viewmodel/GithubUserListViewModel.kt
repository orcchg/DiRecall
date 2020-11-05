package com.orcchg.direcall.feature.githubuserlist.impl.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.orcchg.direcall.core.analytics.api.Analytics
import com.orcchg.direcall.core.ui.BaseViewModel
import com.orcchg.direcall.feature.githubuserlist.api.domain.interactor.GithubUserListInteractor
import com.orcchg.direcall.feature.githubuserlist.api.domain.model.GithubUser
import com.uber.autodispose.autoDispose
import timber.log.Timber
import javax.inject.Inject

class GithubUserListViewModel @Inject constructor(
    private val analytics: Analytics,
    private val interactor: GithubUserListInteractor
) : BaseViewModel() {

    val users: LiveData<List<GithubUser>> by lazy(LazyThreadSafetyMode.NONE) {
        val liveData = MutableLiveData<List<GithubUser>>()
        interactor.users()
            .doOnSubscribe { analytics.sendEvent("get_user_list", "Get list of github users") }
            .autoDispose(this)
            .subscribe({ liveData.value = it }, Timber::e)
        liveData
    }
}
