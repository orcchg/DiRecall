package com.orcchg.direcall.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.orcchg.direcall.github_repo.di.GithubRepoViewModelModule
import com.orcchg.direcall.github_user_details.di.GithubUserDetailsViewModelModule
import com.orcchg.direcall.github_user_list.presentation.viewmodel.GithubUserListViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.multibindings.IntoMap
import javax.inject.Provider

@Module(
    includes = [
        GithubRepoViewModelModule::class, // from assisted inject
        GithubUserDetailsViewModelModule::class, // from assisted inject
        ViewModelModule.Declarations::class
    ]
)
object ViewModelModule {

    @Module
    interface Declarations {

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
