package com.orcchg.direcall.feature.githubuserlist.impl.di

import com.orcchg.direcall.base.Params
import com.orcchg.direcall.core.di.FeatureContainer
import com.orcchg.direcall.core.di.getFeature
import com.orcchg.direcall.core.di.holders.ReleasableFeatureHolder
import com.orcchg.direcall.feature.githubuserlist.api.domain.di.GithubUserListFeatureApi
import dagger.Reusable
import javax.inject.Inject

@Reusable
class GithubUserListFeatureHolder @Inject constructor(
    featureContainer: FeatureContainer
) : ReleasableFeatureHolder<GithubUserListFeatureApi>(featureContainer) {

    override fun buildFeature(params: Params): GithubUserListFeatureApi =
        DaggerGithubUserListFeatureDependenciesComponent.factory()
            .create(
                netCoreLibApi = featureContainer.getFeature(),
                schedulerCoreLibApi = featureContainer.getFeature()
            )
            .let(DaggerGithubUserListFeatureComponent.factory()::create)
}
