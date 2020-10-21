package com.orcchg.direcall.feature.github_user_organizations.impl.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.orcchg.direcall.core.ui.AutoDisposeViewModel
import com.orcchg.direcall.feature.github_user_organizations.api.interactor.GithubOrganizationInteractor
import com.orcchg.direcall.feature.github_user_organizations.api.model.GithubOrganization
import com.uber.autodispose.autoDispose
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Named

class GithubUserOrganizationsViewModel @Inject constructor(
    @Named("login") private val login: String,
    private val interactor: GithubOrganizationInteractor
) : AutoDisposeViewModel() {

    val organizations: LiveData<List<GithubOrganization>> by lazy(LazyThreadSafetyMode.NONE) {
        val liveData = MutableLiveData<List<GithubOrganization>>()
        interactor.organizations(login)
            .autoDispose(this)
            .subscribe({ liveData.value = it }, Timber::e)
        liveData
    }
}
