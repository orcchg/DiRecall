package com.orcchg.direcall.feature.github_user_gists.fake.di

import com.orcchg.direcall.feature.github_user_gists.api.di.GithubGistFeatureApi
import dagger.Component

@Component(modules = [FakeGithubGistFeatureModule::class])
interface FakeGithubGistFeatureComponent : GithubGistFeatureApi
