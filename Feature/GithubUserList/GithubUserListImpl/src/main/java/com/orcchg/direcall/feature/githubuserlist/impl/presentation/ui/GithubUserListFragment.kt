package com.orcchg.direcall.feature.githubuserlist.impl.presentation.ui

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.orcchg.direcall.androidutil.observe
import com.orcchg.direcall.androidutil.viewBindings
import com.orcchg.direcall.core.ui.viewModels
import com.orcchg.direcall.feature.githubuserlist.impl.R
import com.orcchg.direcall.feature.githubuserlist.impl.databinding.FragmentGithubUserListBinding
import com.orcchg.direcall.feature.githubuserlist.impl.presentation.adapter.GithubUserListAdapter
import com.orcchg.direcall.feature.githubuserlist.impl.presentation.viewmodel.GithubUserListViewModelFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class GithubUserListFragment : DaggerFragment(R.layout.fragment_github_user_list) {

    @Inject lateinit var factory: GithubUserListViewModelFactory

    private val adapter = GithubUserListAdapter().apply {
        itemClickListener = {
            GithubUserListFragmentDirections.navActionOpenGithubUserDetails(login = it.login)
                .let(findNavController()::navigate)
        }
    }
    private val binding by viewBindings(FragmentGithubUserListBinding::bind)
    private val viewModel by viewModels(::factory)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvUsers.adapter = adapter

        observe(viewModel.users, adapter::update)
    }
}
