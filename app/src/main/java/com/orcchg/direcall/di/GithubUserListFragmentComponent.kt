package com.orcchg.direcall.di

import com.orcchg.direcall.ui.GithubUserListFragment
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent
interface GithubUserListFragmentComponent : AndroidInjector<GithubUserListFragment> {

    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<GithubUserListFragment>
}
