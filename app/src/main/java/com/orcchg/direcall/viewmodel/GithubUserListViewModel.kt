package com.orcchg.direcall.viewmodel

import androidx.lifecycle.ViewModel
import com.orcchg.direcall.domain.model.GithubUser
import com.orcchg.direcall.domain.usecase.GetGithubUsersUseCase
import io.reactivex.Single

class GithubUserListViewModel(
    private val getGithubUsersUseCase: GetGithubUsersUseCase
) : ViewModel() {

    fun users(): Single<List<GithubUser>> = getGithubUsersUseCase.source()
}
