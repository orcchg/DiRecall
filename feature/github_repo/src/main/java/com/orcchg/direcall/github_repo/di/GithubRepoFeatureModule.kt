package com.orcchg.direcall.github_repo.di

import androidx.lifecycle.ViewModelProvider
import com.orcchg.direcall.github_repo.data.remote.GithubRepoCloudRest
import com.orcchg.direcall.github_repo.presentation.viewmodel.GithubRepoViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.create

@Module(includes = [GithubRepoFeatureModule.Declarations::class])
object GithubRepoFeatureModule {

    @Module
    interface Declarations {
        @Binds
        fun bindViewModelFactory(factory: GithubRepoViewModelFactory): ViewModelProvider.Factory
    }

    @Provides
    fun rest(retrofit: Retrofit): GithubRepoCloudRest = retrofit.create()
}
