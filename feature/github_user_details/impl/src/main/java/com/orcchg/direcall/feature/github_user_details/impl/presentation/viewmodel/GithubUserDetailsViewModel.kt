package com.orcchg.direcall.feature.github_user_details.impl.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.orcchg.direcall.core.ui.AutoDisposeViewModel
import com.orcchg.direcall.feature.github_user_details.pub.domain.interactor.GithubUserDetailsInteractor
import com.orcchg.direcall.feature.github_user_details.pub.model.GithubUserDetails
import com.uber.autodispose.autoDispose
import timber.log.Timber
import javax.inject.Inject

class GithubUserDetailsViewModel @Inject constructor(
    private val interactor: GithubUserDetailsInteractor
) : AutoDisposeViewModel() {

    private val _user = MutableLiveData<GithubUserDetails>()
    internal val user: LiveData<GithubUserDetails> = _user

    fun getUser(login: String) {
        interactor.user(login)
            .autoDispose(this)
            .subscribe({ _user.value = it }, Timber::e)
    }
}
