package com.orcchg.direcall.feature.github_user_gists.impl.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.orcchg.direcall.core.di.FeatureContainer
import com.orcchg.direcall.core.ui.BaseViewModelFactory
import com.orcchg.direcall.feature.github_user_gists.impl.di.GithubGistInternalFeatureApi
import javax.inject.Inject

class GithubUserGistsViewModelFactory @Inject constructor(
    featureContainer: FeatureContainer
) : BaseViewModelFactory<GithubUserGistsViewModel>(featureContainer) {

    override fun create(): ViewModel =
        getFeature<GithubGistInternalFeatureApi>().viewModel()
}
