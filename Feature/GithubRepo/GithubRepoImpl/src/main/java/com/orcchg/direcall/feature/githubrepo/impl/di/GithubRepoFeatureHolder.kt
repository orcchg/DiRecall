package com.orcchg.direcall.feature.githubrepo.impl.di

import com.orcchg.direcall.base.Params
import com.orcchg.direcall.core.di.FeatureContainer
import com.orcchg.direcall.core.di.getFeature
import com.orcchg.direcall.core.di.holders.ReleasableFeatureHolder
import com.orcchg.direcall.feature.githubrepo.api.di.GithubRepoFeatureApi
import dagger.Reusable
import javax.inject.Inject

@Reusable
class GithubRepoFeatureHolder @Inject constructor(
    featureContainer: FeatureContainer
) : ReleasableFeatureHolder<GithubRepoFeatureApi>(featureContainer) {

    override fun buildFeature(params: Params): GithubRepoFeatureApi =
        DaggerGithubRepoFeatureDependenciesComponent.factory()
            .create(
                analyticsCoreLibApi = featureContainer.getFeature(),
                netCoreLibApi = featureContainer.getFeature(),
                schedulerCoreLibApi = featureContainer.getFeature()
            )
            .let {
                DaggerGithubRepoFeatureComponent.factory()
                    .create(
                        login = params.require("login"),
                        dependencies = it
                    )
            }
}
