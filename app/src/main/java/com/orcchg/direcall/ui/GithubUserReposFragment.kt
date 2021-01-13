package com.orcchg.direcall.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.orcchg.direcall.R
import com.orcchg.direcall.adapter.GithubUserReposAdapter
import com.orcchg.direcall.androidutil.argument
import com.orcchg.direcall.androidutil.observe
import com.orcchg.direcall.androidutil.viewBindings
import com.orcchg.direcall.databinding.FragmentGithubUserRepoListBinding
import com.orcchg.direcall.viewmodel.GithubUserReposViewModel
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class GithubUserReposFragment : Fragment(R.layout.fragment_github_user_repo_list) {
    private val binding by viewBindings(FragmentGithubUserRepoListBinding::bind)
    private val login by argument<String>("login")
    private val viewModel by viewModel<GithubUserReposViewModel> { parametersOf(login) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = GithubUserReposAdapter()
        binding.rvRepoItems.adapter = adapter

        observe(viewModel.userReposList, adapter::update)
    }
}