package com.orcchg.direcall.feature.github_user_gists.impl.presentation.ui

import android.os.Bundle
import android.view.View
import com.orcchg.direcall.androidutil.observe
import com.orcchg.direcall.androidutil.viewBindings
import com.orcchg.direcall.core.ui.viewModels
import com.orcchg.direcall.feature.github_user_gists.impl.R
import com.orcchg.direcall.feature.github_user_gists.impl.databinding.FragmentGithubGistListBinding
import com.orcchg.direcall.feature.github_user_gists.impl.presentation.adapter.GithubGistsAdapter
import com.orcchg.direcall.feature.github_user_gists.impl.presentation.viewmodel.GithubUserGistsViewModelFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class GithubUserGistsFragment : DaggerFragment(R.layout.fragment_github_gist_list) {

    @Inject lateinit var factory: GithubUserGistsViewModelFactory

    private val adapter = GithubGistsAdapter()
    private val binding by viewBindings(FragmentGithubGistListBinding::bind)
    private val viewModel by viewModels(::factory)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvGists.adapter = adapter

        observe(viewModel.gists, adapter::update)
    }
}
