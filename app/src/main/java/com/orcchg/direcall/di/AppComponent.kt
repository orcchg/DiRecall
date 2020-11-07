package com.orcchg.direcall.di

import com.orcchg.direcall.App
import com.orcchg.direcall.github_repo.di.GithubRepoBindingsProvider
import com.orcchg.direcall.github_repo.presentation.viewmodel.GithubRepoViewModel
import com.orcchg.direcall.github_user_details.di.GithubUserDetailsBindingsProvider
import com.orcchg.direcall.github_user_details.presentation.viewmodel.GithubUserDetailsViewModel
import com.orcchg.direcall.scheduler_api.di.SchedulersApi
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        NetworkModule::class,
        ViewModelModule::class
    ],
    dependencies = [
        SchedulersApi::class
    ]
)
interface AppComponent :
    AndroidInjector<App>,
    GithubRepoBindingsProvider,
    GithubUserDetailsBindingsProvider {

    override val githubRepoViewModelAssistedFactory: GithubRepoViewModel.RealAssistedFactory
    override val githubUserDetailsViewModelAssistedFactory: GithubUserDetailsViewModel.RealAssistedFactory
}
