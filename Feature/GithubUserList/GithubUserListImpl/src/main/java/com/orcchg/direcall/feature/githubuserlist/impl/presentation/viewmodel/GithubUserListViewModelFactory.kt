package com.orcchg.direcall.feature.githubuserlist.impl.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.orcchg.direcall.core.di.FeatureContainer
import com.orcchg.direcall.core.ui.BaseViewModelFactory
import com.orcchg.direcall.feature.githubuserlist.impl.di.GithubUserListInternalFeatureApi
import javax.inject.Inject

class GithubUserListViewModelFactory @Inject constructor(
    featureContainer: FeatureContainer
) : BaseViewModelFactory<GithubUserListViewModel>(featureContainer) {

    override fun create(): ViewModel =
        getFeature<GithubUserListInternalFeatureApi>().viewModel()
}
