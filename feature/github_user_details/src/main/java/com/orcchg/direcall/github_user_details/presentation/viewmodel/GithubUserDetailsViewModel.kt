package com.orcchg.direcall.github_user_details.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.orcchg.direcall.base.AssistedFactory
import com.orcchg.direcall.github_user_details.domain.model.GithubUserDetails
import com.orcchg.direcall.github_user_details.domain.usecase.GetGithubUserDetailsUseCase
import com.orcchg.direcall.ui_core_lib.AutoDisposeViewModel
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import com.uber.autodispose.autoDispose
import timber.log.Timber

class GithubUserDetailsViewModel @AssistedInject constructor(
    private val getGithubUserDetailsUseCase: GetGithubUserDetailsUseCase,
    @Assisted private val login: String
) : AutoDisposeViewModel() {

    val user: LiveData<GithubUserDetails> by lazy(LazyThreadSafetyMode.NONE) {
        val liveData = MutableLiveData<GithubUserDetails>()
        getGithubUserDetailsUseCase.source { "login" of login }
            .autoDispose(this)
            .subscribe({ liveData.value = it }, Timber::e)
        liveData
    }

    @AssistedInject.Factory
    interface RealAssistedFactory : AssistedFactory {
        fun create(login: String): GithubUserDetailsViewModel
    }
}
