package com.orcchg.direcall.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.orcchg.direcall.androidutil.AutoDisposeViewModel
import com.orcchg.direcall.domain.model.GithubUserDetails
import com.orcchg.direcall.domain.usecase.GetGithubUserDetailsUseCase
import com.uber.autodispose.autoDispose
import timber.log.Timber

class GithubUserDetailsViewModel(
    private val getGithubUserDetailsUseCase: GetGithubUserDetailsUseCase
) : AutoDisposeViewModel() {

    internal lateinit var login: String

    val user: LiveData<GithubUserDetails> by lazy(LazyThreadSafetyMode.NONE) {
        val liveData = MutableLiveData<GithubUserDetails>()
        getGithubUserDetailsUseCase.source { "login" of login }
            .autoDispose(this)
            .subscribe({ liveData.value = it }, Timber::e)
        liveData
    }
}
