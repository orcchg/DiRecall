package com.orcchg.direcall.feature.githubuserdetails.impl.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.orcchg.direcall.core.di.FeatureContainer
import com.orcchg.direcall.core.ui.BaseViewModelFactory
import com.orcchg.direcall.feature.githubuserdetails.impl.di.GithubUserDetailsInternalFeatureApi
import javax.inject.Inject

class GithubUserDetailsViewModelFactory @Inject constructor(
    featureContainer: FeatureContainer
) : BaseViewModelFactory<GithubUserDetailsViewModel>(featureContainer) {

    override fun create(): ViewModel =
        getFeature<GithubUserDetailsInternalFeatureApi>().viewModel()
}
