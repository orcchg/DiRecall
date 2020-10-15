package com.orcchg.direcall.di

import com.orcchg.direcall.github_user_list.presentation.ui.GithubUserListFragment
import com.orcchg.direcall.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface AppModule {

    @ContributesAndroidInjector
    fun mainActivity(): MainActivity

    @ContributesAndroidInjector
    fun githubUserListFragmentInjector(): GithubUserListFragment
}
