package com.orcchg.direcall.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.orcchg.direcall.R
import com.orcchg.direcall.adapter.GithubUserReposAdapter
import com.orcchg.direcall.androidutil.argument
import com.orcchg.direcall.androidutil.observe
import com.orcchg.direcall.androidutil.viewBindings
import com.orcchg.direcall.databinding.FragmentGithubUserRepoListBinding
import com.orcchg.direcall.viewmodel.GithubUserReposViewModel
import com.orcchg.direcall.viewmodel.GithubUserReposViewModelFactory

class GithubUserReposFragment : BaseFragment(R.layout.fragment_github_user_repo_list) {
    private val binding by viewBindings(FragmentGithubUserRepoListBinding::bind)
    private val login by argument<String>("login")
    private val myFactory by lazy { GithubUserReposViewModelFactory(login, serviceLocator.get()) }
    private val viewModel: GithubUserReposViewModel by viewModels { myFactory }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = GithubUserReposAdapter()
        binding.rvRepoItems.adapter = adapter

        observe(viewModel.userReposList, adapter::update)
    }
}