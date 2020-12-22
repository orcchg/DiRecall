package com.orcchg.direcall.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.orcchg.direcall.App
import com.orcchg.direcall.androidutil.AutoDisposeViewModel
import com.orcchg.direcall.domain.model.GithubUserFollower
import com.orcchg.direcall.domain.usecase.GetGithubUserFollowersUseCase
import com.uber.autodispose.autoDispose
import timber.log.Timber

class GithubUserFollowersListViewModel(
    private val login: String,
    private val app: App
) : AutoDisposeViewModel() {

    val followersList: LiveData<List<GithubUserFollower>> by lazy(LazyThreadSafetyMode.NONE) {
        val liveData = MutableLiveData<List<GithubUserFollower>>()
        val useCase = app.serviceLokator[GetGithubUserFollowersUseCase::class.java] as GetGithubUserFollowersUseCase
        useCase.source { "login" of login }
            .autoDispose(this)
            .subscribe({ liveData.value = it }, Timber::e)
        liveData
    }
}