package com.orcchg.direcall.feature.github_user_followers.fake.di

import com.orcchg.direcall.feature.github_user_followers.api.di.GithubFollowerFeatureApi
import dagger.Component

@Component(modules = [FakeGithubFollowerFeatureModule::class])
interface FakeGithubFollowerFeatureComponent : GithubFollowerFeatureApi
