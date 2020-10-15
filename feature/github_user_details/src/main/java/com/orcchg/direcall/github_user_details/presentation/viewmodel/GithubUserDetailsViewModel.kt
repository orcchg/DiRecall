package com.orcchg.direcall.github_user_details.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.orcchg.direcall.ui_core_lib.AutoDisposeViewModel
import com.orcchg.direcall.github_user_details.domain.model.GithubUserDetails
import com.orcchg.direcall.github_user_details.domain.usecase.GetGithubUserDetailsUseCase
import com.uber.autodispose.autoDispose
import timber.log.Timber
import javax.inject.Inject

class GithubUserDetailsViewModel @Inject constructor(
    private val getGithubUserDetailsUseCase: GetGithubUserDetailsUseCase
) : AutoDisposeViewModel() {

    internal var login: String = ""

    val user: LiveData<GithubUserDetails> by lazy(LazyThreadSafetyMode.NONE) {
        val liveData = MutableLiveData<GithubUserDetails>()
        getGithubUserDetailsUseCase.source { "login" of login }
            .autoDispose(this)
            .subscribe({ liveData.value = it }, Timber::e)
        liveData
    }
}
