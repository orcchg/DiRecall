package com.orcchg.direcall.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.orcchg.direcall.App
import com.orcchg.direcall.androidutil.AutoDisposeViewModel
import com.orcchg.direcall.domain.model.GithubUserDetails
import com.orcchg.direcall.domain.usecase.GetGithubUserDetailsUseCase
import com.uber.autodispose.autoDispose
import timber.log.Timber

class GithubUserDetailsViewModel(
    private val login: String,
    private val app: App
) : AutoDisposeViewModel() {

    val user: LiveData<GithubUserDetails> by lazy(LazyThreadSafetyMode.NONE) {
        val liveData = MutableLiveData<GithubUserDetails>()
        val useCase = app.serviceLokator[GetGithubUserDetailsUseCase::class.java] as GetGithubUserDetailsUseCase
        useCase.source { "login" of login }
            .autoDispose(this)
            .subscribe({ liveData.value = it }, Timber::e)
        liveData
    }
}
