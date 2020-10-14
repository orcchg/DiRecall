package com.orcchg.direcall.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.orcchg.direcall.R
import com.orcchg.direcall.adapter.GithubRepoListAdapter
import com.orcchg.direcall.androidutil.observe
import com.orcchg.direcall.androidutil.viewBindings
import com.orcchg.direcall.base.BaseFragment
import com.orcchg.direcall.databinding.FragmentGithubRepoListBinding
import com.orcchg.direcall.viewmodel.GithubRepoViewModel
import com.orcchg.direcall.viewmodel.GithubRepoViewModelFactory

class GithubRepoFragment : BaseFragment(R.layout.fragment_github_repo_list) {

    private val adapter = GithubRepoListAdapter()
    private val binding by viewBindings(FragmentGithubRepoListBinding::bind)
    private val factory by lazy(LazyThreadSafetyMode.NONE) {
        val login = arguments?.getString("login").orEmpty()
        GithubRepoViewModelFactory(login, serviceLocator.githubReposUseCase)
    }
    private val viewModel by viewModels<GithubRepoViewModel> { factory }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvRepos.adapter = adapter

        observe(viewModel.repos, adapter::update)
    }
}
