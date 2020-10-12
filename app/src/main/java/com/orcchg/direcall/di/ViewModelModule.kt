package com.orcchg.direcall.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.orcchg.direcall.viewmodel.GithubRepoViewModel
import com.orcchg.direcall.viewmodel.GithubUserDetailsViewModel
import com.orcchg.direcall.viewmodel.GithubUserListViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import javax.inject.Provider
import javax.inject.Singleton

@Module(includes = [ViewModelModule.Declarations::class])
object ViewModelModule {

    @Module
    interface Declarations {

        @Binds
        @IntoMap
        @ViewModelKey(GithubRepoViewModel::class)
        fun bindGithubRepoViewModel(vm: GithubRepoViewModel): ViewModel

        @Binds
        @IntoMap
        @ViewModelKey(GithubUserDetailsViewModel::class)
        fun bindGithubUserDetailsViewModel(vm: GithubUserDetailsViewModel): ViewModel

        @Binds
        @IntoMap
        @ViewModelKey(GithubUserListViewModel::class)
        fun bindGithubUserListViewModel(vm: GithubUserListViewModel): ViewModel
    }

    @Provides
    @Singleton
    @Suppress("Unchecked_Cast")
    fun provideViewModelFactory(
        multibindings: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
    ): ViewModelProvider.Factory =
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T =
                requireNotNull(multibindings[modelClass]).get() as T
        }
}
