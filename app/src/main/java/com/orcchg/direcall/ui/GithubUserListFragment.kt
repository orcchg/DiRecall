package com.orcchg.direcall.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.orcchg.direcall.R
import com.orcchg.direcall.adapter.GithubUserListAdapter
import com.orcchg.direcall.androidutil.observe
import com.orcchg.direcall.databinding.FragmentGithubUserListBinding
import com.orcchg.direcall.androidutil.viewBindings
import com.orcchg.direcall.viewmodel.GithubUserListViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class GithubUserListFragment : DaggerFragment(R.layout.fragment_github_user_list) {

    @Inject lateinit var factory: ViewModelProvider.Factory

    private val adapter = GithubUserListAdapter().apply {
        itemClickListener = {
            GithubUserListFragmentDirections.navActionOpenGithubUserDetails(login = it.login)
                .let(findNavController()::navigate)
        }
    }
    private val binding by viewBindings(FragmentGithubUserListBinding::bind)
    private val viewModel by viewModels<GithubUserListViewModel> { factory }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvUsers.adapter = adapter

        observe(viewModel.users, adapter::update)
    }
}
