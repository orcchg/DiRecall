package com.orcchg.direcall.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.orcchg.direcall.domain.model.GithubUser
import com.orcchg.direcall.domain.usecase.GetGithubUsersUseCase
import io.reactivex.Single
import timber.log.Timber

class GithubUserListViewModel(
    private val getGithubUsersUseCase: GetGithubUsersUseCase
) : ViewModel() {

    val users: LiveData<List<GithubUser>> by lazy(LazyThreadSafetyMode.NONE) {
        val liveData = MutableLiveData<List<GithubUser>>()
        getGithubUsersUseCase.source()
            .subscribe({ liveData.value = it }, Timber::e)
        liveData
    }
}
