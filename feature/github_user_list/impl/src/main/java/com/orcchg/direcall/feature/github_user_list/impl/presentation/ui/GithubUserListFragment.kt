package com.orcchg.direcall.feature.github_user_list.impl.presentation.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.orcchg.direcall.androidutil.observe
import com.orcchg.direcall.androidutil.viewBindings
import com.orcchg.direcall.core.scopes.ComponentHolder
import com.orcchg.direcall.feature.github_user_list.impl.GithubUserListFeatureInternalApi
import com.orcchg.direcall.feature.github_user_list.impl.R
import com.orcchg.direcall.feature.github_user_list.impl.databinding.FragmentGithubUserListBinding
import com.orcchg.direcall.feature.github_user_list.impl.presentation.adapter.GithubUserListAdapter
import com.orcchg.direcall.feature.github_user_list.impl.presentation.viewmodel.GithubUserListViewModel
import com.orcchg.direcall.feature.github_user_list.impl.presentation.viewmodel.GithubUserListViewModelFactory
import javax.inject.Inject

class GithubUserListFragment : Fragment(R.layout.fragment_github_user_list) {

    @Inject lateinit var factory: GithubUserListViewModelFactory

    private val adapter = GithubUserListAdapter().apply {
        itemClickListener = {
            GithubUserListFragmentDirections.navActionOpenGithubUserDetails(login = it.login)
                .let(findNavController()::navigate)
        }
    }
    private val binding by viewBindings(FragmentGithubUserListBinding::bind)
    private val viewModel by viewModels<GithubUserListViewModel> { factory }

    override fun onAttach(context: Context) {
        ComponentHolder.component<GithubUserListFeatureInternalApi>().inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvUsers.adapter = adapter

        observe(viewModel.users, adapter::update)
    }
}
