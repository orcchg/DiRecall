package com.orcchg.direcall

import com.orcchg.direcall.di.AppComponent
import com.orcchg.direcall.di.DaggerAppComponent
import com.orcchg.direcall.github_repo.di.GithubRepoFragmentComponent
import com.orcchg.direcall.github_repo.di.GithubRepoFragmentComponentHolder
import com.orcchg.direcall.github_repo.di.GithubRepoModule
import com.orcchg.direcall.github_user_details.di.GithubUserDetailsFragmentComponent
import com.orcchg.direcall.github_user_details.di.GithubUserDetailsFragmentComponentHolder
import com.orcchg.direcall.github_user_details.di.GithubUserDetailsModule
import com.orcchg.direcall.scheduler.di.DaggerSchedulersComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import timber.log.Timber

class App :
    DaggerApplication(),
    GithubRepoFragmentComponentHolder,
    GithubUserDetailsFragmentComponentHolder {

    private lateinit var appInjector: AppComponent

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerAppComponent.builder()
            .schedulersApi(DaggerSchedulersComponent.create())
            .build()
            .also { appInjector = it }

    override fun repoComponent(module: GithubRepoModule): GithubRepoFragmentComponent =
        appInjector.repoComponent(module)

    override fun userDetailsComponent(module: GithubUserDetailsModule): GithubUserDetailsFragmentComponent =
        appInjector.userDetailsComponent(module)

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}
