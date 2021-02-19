package com.orcchg.direcall.github_user_details.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.orcchg.direcall.github_user_details.domain.interactor.GithubUserDetailsInteractor
import com.orcchg.direcall.github_user_details.domain.model.GithubUserDetails
import com.orcchg.direcall.ui_core_lib.AutoDisposeViewModel
import com.uber.autodispose.autoDispose
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Named

class GithubUserDetailsViewModel @Inject constructor(
    @Named("login") private val login: String,
    private val interactor: GithubUserDetailsInteractor
) : AutoDisposeViewModel() {

    val user: LiveData<GithubUserDetails> by lazy(LazyThreadSafetyMode.NONE) {
        val liveData = MutableLiveData<GithubUserDetails>()
        interactor.user(login)
            .autoDispose(this)
            .subscribe({ liveData.value = it }, Timber::e)
        liveData
    }
}
