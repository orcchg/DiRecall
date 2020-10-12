package com.orcchg.direcall.di

import com.orcchg.direcall.ui.GithubRepoFragment
import com.orcchg.direcall.ui.GithubUserDetailsFragment
import com.orcchg.direcall.ui.GithubUserListFragment
import com.orcchg.direcall.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface AppModule {

    @ContributesAndroidInjector
    fun mainActivity(): MainActivity

    @ContributesAndroidInjector
    fun githubRepoFragment(): GithubRepoFragment

    @ContributesAndroidInjector
    fun githubUserDetailsFragment(): GithubUserDetailsFragment

    @ContributesAndroidInjector
    fun githubUserListFragment(): GithubUserListFragment
}
