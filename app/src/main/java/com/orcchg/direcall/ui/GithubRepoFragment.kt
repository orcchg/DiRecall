package com.orcchg.direcall.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.orcchg.direcall.R
import com.orcchg.direcall.adapter.GithubRepoListAdapter
import com.orcchg.direcall.androidutil.argument
import com.orcchg.direcall.androidutil.observe
import com.orcchg.direcall.databinding.FragmentGithubRepoListBinding
import com.orcchg.direcall.androidutil.viewBindings
import com.orcchg.direcall.viewmodel.GithubRepoViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class GithubRepoFragment : DaggerFragment(R.layout.fragment_github_repo_list) {

    @Inject lateinit var factory: ViewModelProvider.Factory

    private val adapter = GithubRepoListAdapter()
    private val binding by viewBindings(FragmentGithubRepoListBinding::bind)
    private val login by argument<String>("login")
    private val viewModel by viewModels<GithubRepoViewModel> { factory }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvRepos.adapter = adapter

        viewModel.setLogin(login)
        observe(viewModel.repos, adapter::update)
    }
}
