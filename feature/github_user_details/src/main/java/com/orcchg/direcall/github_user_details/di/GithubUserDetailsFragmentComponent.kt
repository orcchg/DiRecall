package com.orcchg.direcall.github_user_details.di

import com.orcchg.direcall.github_user_details.presentation.ui.GithubUserDetailsFragment
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent(modules = [GithubUserDetailsModule::class])
interface GithubUserDetailsFragmentComponent : AndroidInjector<GithubUserDetailsFragment>
