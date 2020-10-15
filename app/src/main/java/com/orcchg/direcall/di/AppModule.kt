package com.orcchg.direcall.di

import com.orcchg.direcall.github_repo.presentation.ui.GithubRepoFragment
import com.orcchg.direcall.github_user_details.presentation.ui.GithubUserDetailsFragment
import com.orcchg.direcall.github_user_list.presentation.ui.GithubUserListFragment
import com.orcchg.direcall.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface AppModule {

    @ContributesAndroidInjector
    fun mainActivity(): MainActivity

    @ContributesAndroidInjector
    fun githubRepoFragmentInjector(): GithubRepoFragment

    @ContributesAndroidInjector
    fun githubUserDetailsFragmentInjector(): GithubUserDetailsFragment

    @ContributesAndroidInjector
    fun githubUserListFragmentInjector(): GithubUserListFragment
}
