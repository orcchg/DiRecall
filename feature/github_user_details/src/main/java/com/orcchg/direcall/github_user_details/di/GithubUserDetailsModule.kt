package com.orcchg.direcall.github_user_details.di

import androidx.lifecycle.ViewModelProvider
import com.orcchg.direcall.github_user_details.data.convert.GithubUserDetailsCloudConverter
import com.orcchg.direcall.github_user_details.data.remote.GithubUserDetailsCloudRest
import com.orcchg.direcall.github_user_details.data.repository.GithubUserDetailsRepository
import com.orcchg.direcall.github_user_details.domain.usecase.GetGithubUserDetailsUseCase
import com.orcchg.direcall.github_user_details.presentation.viewmodel.GithubUserDetailsViewModelFactory
import org.kodein.di.*
import retrofit2.Retrofit
import retrofit2.create

fun githubUserDetailsModule(login: String) = DI.Module("githubUserDetails") {
    bind<GithubUserDetailsCloudRest>() with singleton { githubUserDetailsCloudRest(instance()) }
    bind<GithubUserDetailsCloudConverter>() with provider { GithubUserDetailsCloudConverter() }
    bind<GithubUserDetailsRepository>() with singleton { GithubUserDetailsRepository(instance(), instance()) }
    bind<GetGithubUserDetailsUseCase>() with provider { GetGithubUserDetailsUseCase(instance(), instance()) }
    bind<ViewModelProvider.Factory>() with provider { GithubUserDetailsViewModelFactory(login, instance()) }
}

private fun githubUserDetailsCloudRest(retrofit: Retrofit): GithubUserDetailsCloudRest =
    retrofit.create()
