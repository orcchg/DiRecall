package com.orcchg.direcall.github_repo.presentation.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.orcchg.direcall.androidutil.argument
import com.orcchg.direcall.androidutil.observe
import com.orcchg.direcall.androidutil.viewBindings
import com.orcchg.direcall.core.di.lib.ComponentHolder
import com.orcchg.direcall.github_repo.R
import com.orcchg.direcall.github_repo.databinding.FragmentGithubRepoListBinding
import com.orcchg.direcall.github_repo.di.DaggerGithubRepoFeatureComponent_DependenciesComponent
import com.orcchg.direcall.github_repo.di.GithubRepoFeatureComponent
import com.orcchg.direcall.github_repo.presentation.adapter.GithubRepoListAdapter
import com.orcchg.direcall.github_repo.presentation.viewmodel.GithubRepoViewModel
import com.orcchg.direcall.ui_core_lib.BaseFragment

class GithubRepoFragment : BaseFragment(R.layout.fragment_github_repo_list) {

    private val adapter = GithubRepoListAdapter()
    private val binding by viewBindings(FragmentGithubRepoListBinding::bind)
    private val login by argument<String>("login")
    private val viewModel by viewModels<GithubRepoViewModel> { factory }

    override fun onAttach(context: Context) {
        val dependencies = DaggerGithubRepoFeatureComponent_DependenciesComponent.factory()
            .create(
                networkApi = ComponentHolder.component(),
                schedulersApi = ComponentHolder.component()
            )
        GithubRepoFeatureComponent.getInstance(dependencies, login).inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvRepos.adapter = adapter

        observe(viewModel.repos, adapter::update)
    }
}
