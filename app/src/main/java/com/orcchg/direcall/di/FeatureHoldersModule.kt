package com.orcchg.direcall.di

import com.orcchg.direcall.core.di.FeatureHolder
import com.orcchg.direcall.core.di.FeatureHolderManager
import com.orcchg.direcall.core.net.api.NetCoreLibApi
import com.orcchg.direcall.core.net.impl.di.NetCoreLibFeatureHolder
import com.orcchg.direcall.core.scheduler.api.SchedulerCoreLibApi
import com.orcchg.direcall.core.scheduler.impl.di.SchedulerCoreLibFeatureHolder
import com.orcchg.direcall.feature.githubrepo.api.di.GithubRepoFeatureApi
import com.orcchg.direcall.feature.githubrepo.impl.di.GithubRepoFeatureHolder
import com.orcchg.direcall.feature.githubrepo.impl.di.GithubRepoInternalFeatureApi
import com.orcchg.direcall.feature.githubuserdetails.api.domain.di.GithubUserDetailsFeatureApi
import com.orcchg.direcall.feature.githubuserdetails.impl.di.GithubUserDetailsFeatureHolder
import com.orcchg.direcall.feature.githubuserdetails.impl.di.GithubUserDetailsInternalFeatureApi
import com.orcchg.direcall.feature.githubuserlist.api.domain.di.GithubUserListFeatureApi
import com.orcchg.direcall.feature.githubuserlist.impl.di.GithubUserListFeatureHolder
import com.orcchg.direcall.feature.githubuserlist.impl.di.GithubUserListInternalFeatureApi
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module(includes = [FeatureHoldersModule.Declarations::class])
object FeatureHoldersModule {

    @Module
    interface Declarations {

        @Binds
        @IntoMap
        @ClassKey(NetCoreLibApi::class)
        fun bindNetCoreLib(holder: NetCoreLibFeatureHolder): FeatureHolder<*>

        @Binds
        @IntoMap
        @ClassKey(SchedulerCoreLibApi::class)
        fun bindSchedulerCoreLib(holder: SchedulerCoreLibFeatureHolder): FeatureHolder<*>

        @Binds
        @IntoMap
        @ClassKey(GithubRepoFeatureApi::class)
        fun bindGithubRepoFeature(holder: GithubRepoFeatureHolder): FeatureHolder<*>

        @Binds
        @IntoMap
        @ClassKey(GithubRepoInternalFeatureApi::class)
        fun bindGithubRepoInternalFeature(holder: GithubRepoFeatureHolder): FeatureHolder<*>

        @Binds
        @IntoMap
        @ClassKey(GithubUserDetailsFeatureApi::class)
        fun bindGithubUserDetailsFeature(holder: GithubUserDetailsFeatureHolder): FeatureHolder<*>

        @Binds
        @IntoMap
        @ClassKey(GithubUserDetailsInternalFeatureApi::class)
        fun bindGithubUserDetailsInternalFeature(holder: GithubUserDetailsFeatureHolder): FeatureHolder<*>

        @Binds
        @IntoMap
        @ClassKey(GithubUserListFeatureApi::class)
        fun bindGithubUserListFeature(holder: GithubUserListFeatureHolder): FeatureHolder<*>

        @Binds
        @IntoMap
        @ClassKey(GithubUserListInternalFeatureApi::class)
        fun bindGithubUserListInternalFeature(holder: GithubUserListFeatureHolder): FeatureHolder<*>
    }

    @Provides
    @JvmSuppressWildcards
    fun provideFeatureHolderManager(
        apiMap: Map<Class<*>, FeatureHolder<*>>
    ): FeatureHolderManager = FeatureHolderManager(apiMap)
}
