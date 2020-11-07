package com.orcchg.direcall

import com.orcchg.direcall.di.AppComponent
import com.orcchg.direcall.di.DaggerAppComponent
import com.orcchg.direcall.github_repo.di.GithubRepoBindingsProvider
import com.orcchg.direcall.github_repo.presentation.viewmodel.GithubRepoViewModel
import com.orcchg.direcall.github_user_details.di.GithubUserDetailsBindingsProvider
import com.orcchg.direcall.github_user_details.presentation.viewmodel.GithubUserDetailsViewModel
import com.orcchg.direcall.scheduler.di.DaggerSchedulersComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import timber.log.Timber

class App :
    DaggerApplication(),
    GithubRepoBindingsProvider,
    GithubUserDetailsBindingsProvider {

    private lateinit var appComponent: AppComponent

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerAppComponent.builder()
            .schedulersApi(DaggerSchedulersComponent.create())
            .build()
            .also { appComponent = it }

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }

    override val githubRepoViewModelAssistedFactory: GithubRepoViewModel.RealAssistedFactory
        get() = appComponent.githubRepoViewModelAssistedFactory

    override val githubUserDetailsViewModelAssistedFactory: GithubUserDetailsViewModel.RealAssistedFactory
        get() = appComponent.githubUserDetailsViewModelAssistedFactory
}
