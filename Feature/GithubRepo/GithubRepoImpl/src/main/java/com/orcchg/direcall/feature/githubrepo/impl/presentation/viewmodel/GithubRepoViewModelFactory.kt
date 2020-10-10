package com.orcchg.direcall.feature.githubrepo.impl.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.orcchg.direcall.core.di.FeatureContainer
import com.orcchg.direcall.core.ui.BaseViewModelFactory
import com.orcchg.direcall.feature.githubrepo.impl.di.GithubRepoInternalFeatureApi
import javax.inject.Inject

class GithubRepoViewModelFactory @Inject constructor(
    featureContainer: FeatureContainer
) : BaseViewModelFactory<GithubRepoViewModel>(featureContainer) {

    override fun create(): ViewModel =
        getFeature<GithubRepoInternalFeatureApi>().viewModel()
}
