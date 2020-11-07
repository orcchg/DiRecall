package com.orcchg.direcall.github_repo.di

import com.squareup.inject.assisted.dagger2.AssistedModule
import dagger.Module

@AssistedModule
@Module(includes = [AssistedInject_GithubRepoViewModelModule::class])
interface GithubRepoViewModelModule
