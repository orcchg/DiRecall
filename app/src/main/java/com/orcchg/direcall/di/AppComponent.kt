package com.orcchg.direcall.di

import com.orcchg.direcall.App
import com.orcchg.direcall.data.di.DataFeatureApi
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        SchedulersFactoryModule::class
    ],
    dependencies = [
        DataFeatureApi::class
    ]
)
@Singleton
interface AppComponent : AndroidInjector<App> {

    fun repoComponent(
        module: GithubUserRepoFragmentModule
    ): GithubUserRepoFragmentComponent

    fun userDetailsComponent(
        module: GithubUserDetailsFragmentModule
    ): GithubUserDetailsFragmentComponent
}
