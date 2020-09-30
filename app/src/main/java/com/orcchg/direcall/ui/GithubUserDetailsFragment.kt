package com.orcchg.direcall.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.jakewharton.rxbinding3.view.clicks
import com.orcchg.direcall.R
import com.orcchg.direcall.androidutil.argument
import com.orcchg.direcall.androidutil.clickDebounce
import com.orcchg.direcall.androidutil.observe
import com.orcchg.direcall.androidutil.SchedulersFactoryImpl
import com.orcchg.direcall.base.usecase.UseCaseThreadExecutor
import com.orcchg.direcall.data.convert.GithubRepoCloudConverter
import com.orcchg.direcall.data.convert.GithubUserCloudConverter
import com.orcchg.direcall.data.convert.GithubUserDetailsCloudConverter
import com.orcchg.direcall.data.remote.CloudModule
import com.orcchg.direcall.data.repository.GithubRepositoryImpl
import com.orcchg.direcall.databinding.FragmentGithubUserDetailsBinding
import com.orcchg.direcall.androidutil.viewBindings
import com.orcchg.direcall.domain.usecase.GetGithubUserDetailsUseCase
import com.orcchg.direcall.viewmodel.GithubUserDetailsViewModel
import com.orcchg.direcall.viewmodel.GithubUserDetailsViewModelFactory
import retrofit2.create

class GithubUserDetailsFragment : Fragment(R.layout.fragment_github_user_details) {

    private val binding by viewBindings(FragmentGithubUserDetailsBinding::bind)
    private val login by argument<String>("login")
    private val factory by lazy(LazyThreadSafetyMode.NONE) {
        val logger = CloudModule.loggingInterceptor()
        val moshi = CloudModule.moshi()
        val okHttpClient = CloudModule.okHttpClient(logger)
        val retrofit = CloudModule.retrofit(okHttpClient, moshi)

        GithubUserDetailsViewModelFactory(
            login = login,
            getGithubUserDetailsUseCase = GetGithubUserDetailsUseCase(
                repository = GithubRepositoryImpl(
                    repoCloud = retrofit.create(),
                    userCloud = retrofit.create(),
                    repoConverter = GithubRepoCloudConverter(),
                    userConverter = GithubUserCloudConverter(),
                    userDetailsConverter = GithubUserDetailsCloudConverter()
                ),
                schedulersFactory = SchedulersFactoryImpl(
                    useCaseExecutor = UseCaseThreadExecutor()
                )
            )
        )
    }
    private val viewModel by viewModels<GithubUserDetailsViewModel> { factory }

    @SuppressLint("AutoDispose", "CheckResult")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnRepoList.clicks().clickDebounce()
            .subscribe {
                GithubUserDetailsFragmentDirections.navActionOpenGithubRepoList(login = login)
                    .let(findNavController()::navigate)
            }

        observe(viewModel.user) {
            Glide.with(this)
                .load(it.avatarUrl)
                .into(binding.ivAvatar)

            binding.tvTitle.text = it.login
        }
    }
}
