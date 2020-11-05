package com.orcchg.direcall.feature.githubuserdetails.impl.di

import com.orcchg.direcall.base.Params
import com.orcchg.direcall.core.di.FeatureContainer
import com.orcchg.direcall.core.di.getFeature
import com.orcchg.direcall.core.di.holders.ReleasableFeatureHolder
import com.orcchg.direcall.feature.githubuserdetails.api.domain.di.GithubUserDetailsFeatureApi
import dagger.Reusable
import javax.inject.Inject

@Reusable
class GithubUserDetailsFeatureHolder @Inject constructor(
    featureContainer: FeatureContainer
) : ReleasableFeatureHolder<GithubUserDetailsFeatureApi>(featureContainer) {

    override fun buildFeature(params: Params): GithubUserDetailsFeatureApi =
        DaggerGithubUserDetailsFeatureDependenciesComponent.factory()
            .create(
                analyticsCoreLibApi = featureContainer.getFeature(),
                netCoreLibApi = featureContainer.getFeature(),
                schedulerCoreLibApi = featureContainer.getFeature()
            )
            .let {
                DaggerGithubUserDetailsFeatureComponent.factory()
                    .create(
                        login = params.require("login"),
                        dependencies = it
                    )
            }
}
