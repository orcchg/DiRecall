package com.orcchg.direcall

import android.app.Application
import com.orcchg.direcall.github_repo.di.githubRepoModule
import com.orcchg.direcall.github_user_details.di.githubUserDetailsModule
import com.orcchg.direcall.github_user_list.di.githubUserListModule
import com.orcchg.direcall.network.networkModule
import com.orcchg.direcall.scheduler.di.schedulerModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@App)
            modules(
                networkModule,
                schedulerModule,
                githubRepoModule,
                githubUserDetailsModule,
                githubUserListModule
            )
        }
    }
}
