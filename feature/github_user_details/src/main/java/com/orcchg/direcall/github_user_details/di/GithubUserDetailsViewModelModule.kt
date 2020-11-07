package com.orcchg.direcall.github_user_details.di

import com.squareup.inject.assisted.dagger2.AssistedModule
import dagger.Module

@AssistedModule
@Module(includes = [AssistedInject_GithubUserDetailsViewModelModule::class])
interface GithubUserDetailsViewModelModule
