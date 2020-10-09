package com.orcchg.direcall.di

import com.orcchg.direcall.ui.GithubUserListFragment
import com.orcchg.direcall.ui.MainActivity
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module(
    subcomponents = [
        GithubUserListFragmentComponent::class
    ]
)
interface AppModule {

    /**
     * Approach 1 - generate and bind subcomponent automatically
     */
    @ContributesAndroidInjector
    fun mainActivity(): MainActivity

    /**
     * Approach 2 - generate subcomponent from factory and bind manually
     */
    @Binds
    @IntoMap
    @ClassKey(GithubUserListFragment::class)
    fun bindGithubUserListFragmentInjector(
        factory: GithubUserListFragmentComponent.Factory
    ): AndroidInjector.Factory<*>
}
