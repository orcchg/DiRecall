package com.orcchg.direcall.feature.github_user_organizations.fake.di

import com.orcchg.direcall.feature.github_user_organizations.api.di.GithubOrganizationFeatureApi
import dagger.Component

@Component(modules = [FakeGithubOrganizationFeatureModule::class])
interface FakeGithubOrganizationFeatureComponent : GithubOrganizationFeatureApi
