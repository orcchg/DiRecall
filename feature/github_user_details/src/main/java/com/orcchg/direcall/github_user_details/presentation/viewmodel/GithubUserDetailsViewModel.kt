package com.orcchg.direcall.github_user_details.presentation.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.orcchg.direcall.github_user_details.domain.model.GithubUserDetails
import com.orcchg.direcall.github_user_details.domain.usecase.GetGithubUserDetailsUseCase
import com.orcchg.direcall.ui_core_lib.AutoDisposeViewModel
import com.uber.autodispose.autoDispose
import timber.log.Timber

class GithubUserDetailsViewModel @ViewModelInject constructor(
    private val getGithubUserDetailsUseCase: GetGithubUserDetailsUseCase
) : AutoDisposeViewModel() {

    private val _user = MutableLiveData<GithubUserDetails>()
    val user: LiveData<GithubUserDetails> = _user

    internal fun getUser(login: String) {
        getGithubUserDetailsUseCase.source { "login" of login }
            .autoDispose(this)
            .subscribe({ _user.value = it }, Timber::e)
    }
}
