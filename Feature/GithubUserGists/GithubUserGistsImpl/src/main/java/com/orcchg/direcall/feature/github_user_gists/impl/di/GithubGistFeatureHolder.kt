package com.orcchg.direcall.feature.github_user_gists.impl.di

import com.orcchg.direcall.base.Params
import com.orcchg.direcall.core.di.FeatureContainer
import com.orcchg.direcall.core.di.getFeature
import com.orcchg.direcall.core.di.holders.ReleasableFeatureHolder
import com.orcchg.direcall.feature.github_user_gists.api.di.GithubGistFeatureApi
import dagger.Reusable
import javax.inject.Inject

@Reusable
class GithubGistFeatureHolder @Inject constructor(
    featureContainer: FeatureContainer
) : ReleasableFeatureHolder<GithubGistFeatureApi>(featureContainer) {

    override fun buildFeature(params: Params): GithubGistFeatureApi =
        DaggerGithubGistFeatureDependenciesComponent.factory()
            .create(
                netCoreLibApi = featureContainer.getFeature(),
                schedulerCoreLibApi = featureContainer.getFeature()
            )
            .let {
                DaggerGithubGistFeatureComponent.factory()
                    .create(
                        login = params.require("login"),
                        dependencies = it
                    )
            }
}
