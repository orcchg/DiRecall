package com.orcchg.direcall.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.orcchg.direcall.androidutil.AutoDisposeViewModel
import com.orcchg.direcall.domain.model.GithubUserDetails
import com.orcchg.direcall.domain.usecase.GetGithubUserDetailsUseCase
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
