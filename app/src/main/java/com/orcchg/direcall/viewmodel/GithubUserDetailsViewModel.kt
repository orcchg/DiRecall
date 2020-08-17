package com.orcchg.direcall.viewmodel

import androidx.lifecycle.ViewModel
import com.orcchg.direcall.domain.model.GithubUserDetails
import com.orcchg.direcall.domain.usecase.GetGithubUserDetailsUseCase
import io.reactivex.Single

class GithubUserDetailsViewModel(
    private val getGithubUserDetailsUseCase: GetGithubUserDetailsUseCase
) : ViewModel() {

    fun user(login: String): Single<GithubUserDetails> =
        getGithubUserDetailsUseCase.source { "login" of login }
}
