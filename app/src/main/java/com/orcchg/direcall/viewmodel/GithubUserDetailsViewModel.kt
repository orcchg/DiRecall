package com.orcchg.direcall.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.orcchg.direcall.domain.model.GithubUserDetails
import com.orcchg.direcall.domain.usecase.GetGithubUserDetailsUseCase
import timber.log.Timber

class GithubUserDetailsViewModel(
    private val login: String,
    private val getGithubUserDetailsUseCase: GetGithubUserDetailsUseCase
) : ViewModel() {

    val user: LiveData<GithubUserDetails> by lazy(LazyThreadSafetyMode.NONE) {
        val liveData = MutableLiveData<GithubUserDetails>()
        getGithubUserDetailsUseCase.source { "login" of login }
            .subscribe({ liveData.value = it }, Timber::e)
        liveData
    }
}
