package com.orcchg.direcall.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.orcchg.direcall.github_repo.presentation.viewmodel.GithubRepoViewModel
import com.orcchg.direcall.github_user_details.presentation.viewmodel.GithubUserDetailsViewModel
import com.orcchg.direcall.github_user_list.presentation.viewmodel.GithubUserListViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.multibindings.IntoMap
import javax.inject.Provider

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
    @Reusable
    @Suppress("Unchecked_Cast")
    fun provideViewModelFactory(
        multibindings: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
    ): ViewModelProvider.Factory =
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T =
                requireNotNull(multibindings[modelClass]).get() as T
        }
}
