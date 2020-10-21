package com.orcchg.direcall.feature.github_user_gists.impl.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.orcchg.direcall.core.di.FeatureContainer
import com.orcchg.direcall.core.di.getFeature
import com.orcchg.direcall.core.ui.BaseViewModelFactory
import com.orcchg.direcall.feature.github_user_gists.impl.di.DaggerGithubGistFeatureComponent
import com.orcchg.direcall.feature.github_user_gists.impl.di.DaggerGithubGistFeatureDependenciesComponent
import javax.inject.Inject
import javax.inject.Named

class GithubUserGistsViewModelFactory @Inject constructor(
    @Named("login") private val login: String,
    featureContainer: FeatureContainer
) : BaseViewModelFactory<GithubUserGistsViewModel>(featureContainer) {

    override fun create(): ViewModel =
        DaggerGithubGistFeatureDependenciesComponent.factory()
            .create(
                netCoreLibApi = featureContainer.getFeature(),
                schedulerCoreLibApi = featureContainer.getFeature()
            )
            .let {
                DaggerGithubGistFeatureComponent.factory()
                    .create(
                        login = login,
                        dependencies = it
                    )
            }
            .viewModel()
}
