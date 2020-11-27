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
import com.orcchg.direcall.androidutil.*
import com.orcchg.direcall.databinding.FragmentGithubUserDetailsBinding
import com.orcchg.direcall.base.usecase.UseCaseThreadExecutor
import com.orcchg.direcall.data.convert.GithubUserDetailsCloudConverter
import com.orcchg.direcall.data.model.GithubUserDetailsEntity
import com.orcchg.direcall.data.remote.GithubUserCloudRest
import com.orcchg.direcall.data.repository.GithubRepositoryImpl
import com.orcchg.direcall.domain.usecase.GetGithubUserDetailsUseCase
import com.orcchg.direcall.viewmodel.GithubUserDetailsViewModel
import com.orcchg.direcall.viewmodel.GithubUserDetailsViewModelFactory
import io.reactivex.Single

class GithubUserDetailsFragment : Fragment(R.layout.fragment_github_user_details) {

    private val binding by viewBindings(FragmentGithubUserDetailsBinding::bind)
    private val login by argument<String>("login")
    private val executor = UseCaseThreadExecutor()
    private val userCloud = object : GithubUserCloudRest {
        override fun userDetails(login: String): Single<GithubUserDetailsEntity> {
            return Single.just(GithubUserDetailsEntity(0, "" , null, null, null))
        }
    }
    private val converter = GithubUserDetailsCloudConverter()
    private val scheduler = SchedulersFactoryImpl(executor)
    private val gitRepo = GithubRepositoryImpl(userCloud, converter)
    private val useCase = GetGithubUserDetailsUseCase(gitRepo, scheduler)
    private val myFactory by lazy(){ GithubUserDetailsViewModelFactory(login, useCase) }
    private val viewModel: GithubUserDetailsViewModel by viewModels {myFactory}

    @SuppressLint("AutoDispose", "CheckResult")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnRepoList.clicks().clickDebounce()
            .subscribe {
                // TODO: implement
            }

        observe(viewModel.user) {
            Glide.with(this)
                .load(it.avatarUrl)
                .into(binding.ivAvatar)

            binding.tvTitle.text = it.login
        }
    }
}
