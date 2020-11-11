package com.orcchg.direcall.di

import com.orcchg.direcall.feature.githubrepo.impl.presentation.ui.GithubRepoFragment
import com.orcchg.direcall.feature.githubuserlist.impl.presentation.ui.GithubUserListFragment
import com.orcchg.direcall.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface MainActivityModule {

    @ContributesAndroidInjector
    fun mainActivityInjector(): MainActivity

    @ContributesAndroidInjector
    fun githubRepoFragmentInjector(): GithubRepoFragment

    @ContributesAndroidInjector
    fun githubUserListFragmentInjector(): GithubUserListFragment
}
