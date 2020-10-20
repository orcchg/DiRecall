package com.orcchg.direcall.github_repo.presentation.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.orcchg.direcall.androidutil.argument
import com.orcchg.direcall.androidutil.observe
import com.orcchg.direcall.androidutil.viewBindings
import com.orcchg.direcall.di.AppCoreApi
import com.orcchg.direcall.di.getFeature
import com.orcchg.direcall.github_repo.R
import com.orcchg.direcall.github_repo.databinding.FragmentGithubRepoListBinding
import com.orcchg.direcall.github_repo.di.DaggerGithubRepoFragmentComponent
import com.orcchg.direcall.github_repo.di.GithubRepoModule
import com.orcchg.direcall.github_repo.presentation.adapter.GithubRepoListAdapter
import com.orcchg.direcall.github_repo.presentation.viewmodel.GithubRepoViewModel
import com.orcchg.direcall.github_repo.presentation.viewmodel.GithubRepoViewModelFactory
import javax.inject.Inject

class GithubRepoFragment : Fragment(R.layout.fragment_github_repo_list) {

    @Inject lateinit var factory: GithubRepoViewModelFactory

    private val adapter = GithubRepoListAdapter()
    private val binding by viewBindings(FragmentGithubRepoListBinding::bind)
    private val login by argument<String>("login")
    private val viewModel by viewModels<GithubRepoViewModel> { factory }

    override fun onAttach(context: Context) {
        val api = (requireActivity().application as AppCoreApi)
        DaggerGithubRepoFragmentComponent.factory()
            .create(
                module = GithubRepoModule(login),
                networkApi = api.getFeature(),
                schedulerApi = api.getFeature()
            )
            .inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvRepos.adapter = adapter

        observe(viewModel.repos, adapter::update)
    }
}
