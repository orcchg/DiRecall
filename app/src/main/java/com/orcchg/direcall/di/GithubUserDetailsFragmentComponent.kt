package com.orcchg.direcall.di

import com.orcchg.direcall.ui.GithubUserDetailsFragment
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent(modules = [GithubUserDetailsFragmentModule::class])
interface GithubUserDetailsFragmentComponent : AndroidInjector<GithubUserDetailsFragment>
