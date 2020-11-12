package com.orcchg.direcall.feature.github_user_details.fake.di

import com.orcchg.direcall.feature.githubuserdetails.api.domain.di.GithubUserDetailsFeatureApi
import dagger.Component

@Component(modules = [FakeGithubUserDetailsFeatureModule::class])
interface FakeGithubUserDetailsFeatureComponent : GithubUserDetailsFeatureApi
