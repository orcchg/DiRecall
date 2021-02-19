package com.orcchg.direcall.github_user_list.di

import androidx.lifecycle.ViewModelProvider
import com.orcchg.direcall.github_user_list.data.remote.GithubUserListCloudRest
import com.orcchg.direcall.github_user_list.presentation.viewmodel.GithubUserListViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.create

@Module(includes = [GithubUserListFeatureModule.Declarations::class])
object GithubUserListFeatureModule {

    @Module
    interface Declarations {
        @Binds
        fun bindViewModelFactory(factory: GithubUserListViewModelFactory): ViewModelProvider.Factory
    }

    @Provides
    fun rest(retrofit: Retrofit): GithubUserListCloudRest = retrofit.create()
}
