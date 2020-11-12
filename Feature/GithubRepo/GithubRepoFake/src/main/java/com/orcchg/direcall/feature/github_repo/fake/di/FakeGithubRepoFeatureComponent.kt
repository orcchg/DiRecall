package com.orcchg.direcall.feature.github_repo.fake.di

import com.orcchg.direcall.feature.githubrepo.api.di.GithubRepoFeatureApi
import dagger.Component

@Component(modules = [FakeGithubRepoFeatureModule::class])
interface FakeGithubRepoFeatureComponent : GithubRepoFeatureApi
