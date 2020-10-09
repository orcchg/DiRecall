package com.orcchg.direcall.di

import com.orcchg.direcall.ui.GithubRepoFragment
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent(modules = [GithubUserRepoFragmentModule::class])
interface GithubUserRepoFragmentComponent : AndroidInjector<GithubRepoFragment>
