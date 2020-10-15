package com.orcchg.direcall.github_repo.di

import com.orcchg.direcall.github_repo.presentation.ui.GithubRepoFragment
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent(modules = [GithubRepoModule::class])
interface GithubRepoFragmentComponent : AndroidInjector<GithubRepoFragment>
