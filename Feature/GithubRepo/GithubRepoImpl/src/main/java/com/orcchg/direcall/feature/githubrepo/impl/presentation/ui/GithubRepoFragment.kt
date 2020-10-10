package com.orcchg.direcall.feature.githubrepo.impl.presentation.ui

import android.os.Bundle
import android.view.View
import com.orcchg.direcall.androidutil.observe
import com.orcchg.direcall.androidutil.viewBindings
import com.orcchg.direcall.core.ui.viewModels
import com.orcchg.direcall.feature.githubrepo.impl.R
import com.orcchg.direcall.feature.githubrepo.impl.databinding.FragmentGithubRepoListBinding
import com.orcchg.direcall.feature.githubrepo.impl.presentation.adapter.GithubRepoListAdapter
import com.orcchg.direcall.feature.githubrepo.impl.presentation.viewmodel.GithubRepoViewModelFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class GithubRepoFragment : DaggerFragment(R.layout.fragment_github_repo_list) {

    @Inject lateinit var factory: GithubRepoViewModelFactory

    private val adapter = GithubRepoListAdapter()
    private val binding by viewBindings(FragmentGithubRepoListBinding::bind)
    private val viewModel by viewModels(::factory)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvRepos.adapter = adapter

        observe(viewModel.repos, adapter::update)
    }
}
