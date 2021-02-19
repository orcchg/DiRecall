package com.orcchg.direcall.github_user_details.di

import androidx.lifecycle.ViewModelProvider
import com.orcchg.direcall.github_user_details.data.remote.GithubUserDetailsCloudRest
import com.orcchg.direcall.github_user_details.presentation.viewmodel.GithubUserDetailsViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.create

@Module(includes = [GithubUserDetailsFeatureModule.Declarations::class])
object GithubUserDetailsFeatureModule {

    @Module
    interface Declarations {
        @Binds
        fun bindViewModelFactory(factory: GithubUserDetailsViewModelFactory): ViewModelProvider.Factory
    }

    @Provides
    fun rest(retrofit: Retrofit): GithubUserDetailsCloudRest = retrofit.create()
}
