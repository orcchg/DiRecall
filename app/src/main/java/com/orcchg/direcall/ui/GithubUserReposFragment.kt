package com.orcchg.direcall.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.orcchg.direcall.R
import com.orcchg.direcall.adapter.GithubUserReposAdapter
import com.orcchg.direcall.androidutil.argument
import com.orcchg.direcall.androidutil.observe
import com.orcchg.direcall.androidutil.viewBindings
import com.orcchg.direcall.databinding.FragmentGithubUserRepoListBinding
import com.orcchg.direcall.di.DaggerGithubUserReposFeatureComponent
import com.orcchg.direcall.viewmodel.GithubUserReposViewModel
import com.orcchg.direcall.viewmodel.GithubUserReposViewModelFactory
import javax.inject.Inject

class GithubUserReposFragment : BaseFragment(R.layout.fragment_github_user_repo_list) {

    override fun onAttach(context: Context) {
        DaggerGithubUserReposFeatureComponent
            .factory()
            .create(login, networkComponent, repositoryComponent, schedulerComponent)
            .inject(this)
        super.onAttach(context)
    }

    private val binding by viewBindings(FragmentGithubUserRepoListBinding::bind)
    private val login by argument<String>("login")
    @Inject lateinit var myFactory: GithubUserReposViewModelFactory
    private val viewModel: GithubUserReposViewModel by viewModels { myFactory }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = GithubUserReposAdapter()
        binding.rvRepoItems.adapter = adapter

        observe(viewModel.userReposList, adapter::update)
    }
}