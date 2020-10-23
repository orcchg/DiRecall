package com.orcchg.direcall.feature.github_repo.impl.presentation.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.orcchg.direcall.androidutil.argument
import com.orcchg.direcall.feature.github_repo.impl.presentation.adapter.GithubRepoListAdapter
import com.orcchg.direcall.androidutil.observe
import com.orcchg.direcall.androidutil.viewBindings
import com.orcchg.direcall.core.scopes.ComponentHolder
import com.orcchg.direcall.feature.github_repo.impl.GithubRepoFeatureInternalApi
import com.orcchg.direcall.feature.github_repo.impl.R
import com.orcchg.direcall.feature.github_repo.impl.databinding.FragmentGithubRepoListBinding
import com.orcchg.direcall.feature.github_repo.impl.presentation.viewmodel.GithubRepoViewModel
import com.orcchg.direcall.feature.github_repo.impl.presentation.viewmodel.GithubRepoViewModelFactory
import javax.inject.Inject

class GithubRepoFragment : Fragment(R.layout.fragment_github_repo_list) {

    @Inject lateinit var factory: GithubRepoViewModelFactory

    private val adapter = GithubRepoListAdapter()
    private val binding by viewBindings(FragmentGithubRepoListBinding::bind)
    private val login by argument<String>("login")
    private val viewModel by viewModels<GithubRepoViewModel> { factory }

    override fun onAttach(context: Context) {
        ComponentHolder.component<GithubRepoFeatureInternalApi>().inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvRepos.adapter = adapter

        observe(viewModel.repos, adapter::update)
    }

    override fun onStart() {
        super.onStart()
        viewModel.getRepos(login)
    }
}
