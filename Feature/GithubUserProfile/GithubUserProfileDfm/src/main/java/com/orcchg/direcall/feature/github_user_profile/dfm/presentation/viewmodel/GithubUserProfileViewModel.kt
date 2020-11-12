package com.orcchg.direcall.feature.github_user_profile.dfm.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.orcchg.direcall.core.analytics.api.Analytics
import com.orcchg.direcall.core.di.FeatureContainer
import com.orcchg.direcall.core.di.FeatureHolder
import com.orcchg.direcall.core.di.releaseFeature
import com.orcchg.direcall.core.ui.AutoDisposeViewModel
import com.orcchg.direcall.core.ui.BaseViewModel
import com.orcchg.direcall.core.ui.BaseViewModelFactory
import com.orcchg.direcall.feature.github_user_followers.api.interactor.GithubFollowerInteractor
import com.orcchg.direcall.feature.github_user_gists.api.interactor.GithubGistInteractor
import com.orcchg.direcall.feature.github_user_organizations.api.interactor.GithubOrganizationInteractor
import com.orcchg.direcall.feature.github_user_organizations.api.model.GithubOrganization
import com.orcchg.direcall.feature.github_user_profile.api.interactor.GithubProfileInteractor
import com.orcchg.direcall.feature.github_user_profile.api.model.GithubProject
import com.orcchg.direcall.feature.github_user_profile.dfm.model.presentation.Triplet
import com.orcchg.direcall.feature.githubrepo.api.di.GithubRepoFeatureApi
import com.orcchg.direcall.feature.githubrepo.api.interactor.GithubRepoInteractor
import com.orcchg.direcall.feature.githubrepo.api.model.GithubRepo
import com.orcchg.direcall.feature.githubuserdetails.api.domain.interactor.GithubUserDetailsInteractor
import com.orcchg.direcall.feature.githubuserdetails.api.domain.model.GithubUserDetails
import com.uber.autodispose.autoDispose
import io.reactivex.Single
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Named

class GithubUserProfileViewModel @Inject constructor(
    @Named("login") private val login: String,
    private val analytics: Analytics,
    private val featureContainer: FeatureContainer,
    private val followerInteractor: GithubFollowerInteractor,
    private val gistInteractor: GithubGistInteractor,
    private val organizationInteractor: GithubOrganizationInteractor,
    private val profileInteractor: GithubProfileInteractor,
    private val repoInteractor: GithubRepoInteractor,
    private val userDetailsInteractor: GithubUserDetailsInteractor
) : AutoDisposeViewModel() {

    /**
     * DFM doesn't use [BaseViewModel] because there are some lateinit properties that
     * aren't initialized in new Lib + DFM architecture. These properties are initialized
     * only within [BaseViewModelFactory] where FeatureAPI and FeatureHolder is lazily
     * created and put into FeatureHolders map in [FeatureContainer]. This is not the case.
     *
     * But features held by [FeatureHolder] from [FeatureContainer] could be stateful
     * and ref counted. This makes it possible to leak the state of feature out of the scope
     * of feature screen. So, in order to use such features in Lib + DFM, one should
     * keep track of ref counting for them: release the feature if accessed.
     *
     * This is a drawback of migration. Need to investigate better solution.
     */
    override fun onCleared() {
        super.onCleared()
        featureContainer.releaseFeature<GithubRepoFeatureApi>()
    }

    val organizations: LiveData<List<GithubOrganization>> by lazy(LazyThreadSafetyMode.NONE) {
        val liveData = MutableLiveData<List<GithubOrganization>>()
        organizationInteractor.organizations(login)
            .doOnSubscribe { analytics.sendEvent("get_organizations", "Get list of organizations for github user $login") }
            .autoDispose(this)
            .subscribe({ liveData.value = it }, Timber::e)
        liveData
    }

    val projects: LiveData<List<GithubProject>> by lazy(LazyThreadSafetyMode.NONE) {
        val liveData = MutableLiveData<List<GithubProject>>()
        profileInteractor.projects(login)
            .doOnSubscribe { analytics.sendEvent("get_projects", "Get list of projects for github user $login") }
            .autoDispose(this)
            .subscribe({ liveData.value = it }, Timber::e)
        liveData
    }

    val repos: LiveData<List<GithubRepo>> by lazy(LazyThreadSafetyMode.NONE) {
        val liveData = MutableLiveData<List<GithubRepo>>()
        repoInteractor.repos(login)
            .doOnSubscribe { analytics.sendEvent("get_repos", "Get list of repositories for github user $login") }
            .autoDispose(this)
            .subscribe({ liveData.value = it }, Timber::e)
        liveData
    }

    val user: LiveData<GithubUserDetails> by lazy(LazyThreadSafetyMode.NONE) {
        val liveData = MutableLiveData<GithubUserDetails>()
        userDetailsInteractor.user(login)
            .doOnSubscribe { analytics.sendEvent("get_user_details", "Get details for github user $login") }
            .autoDispose(this)
            .subscribe({ liveData.value = it }, Timber::e)
        liveData
    }

    val counters: LiveData<Triplet> by lazy(LazyThreadSafetyMode.NONE) {
        val liveData = MutableLiveData<Triplet>()

        Single.zip(
            profileInteractor.events(login),
            followerInteractor.followers(login),
            gistInteractor.gists(login)
        ) { events, followers, gists ->
            Triplet(
                events = events.size,
                followers = followers.size,
                gists = gists.size
            )
        }
            .doOnSubscribe { analytics.sendEvent("get_counters", "Get number of events / followers / gists for user $login") }
            .autoDispose(this)
            .subscribe({ liveData.value = it }, Timber::e)

        liveData
    }
}
