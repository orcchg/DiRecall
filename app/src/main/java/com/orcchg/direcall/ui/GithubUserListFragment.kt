package com.orcchg.direcall.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.orcchg.direcall.R
import com.orcchg.direcall.adapter.GithubUserListAdapter
import com.orcchg.direcall.androidutil.observe
import com.orcchg.direcall.databinding.FragmentGithubUserListBinding
import com.orcchg.direcall.androidutil.viewBindings
import com.orcchg.direcall.base.BaseFragment
import com.orcchg.direcall.viewmodel.GithubUserListViewModel
import com.orcchg.direcall.viewmodel.GithubUserListViewModelFactory

class GithubUserListFragment : BaseFragment(R.layout.fragment_github_user_list) {

    private val adapter = GithubUserListAdapter().apply {
        itemClickListener = {
            GithubUserListFragmentDirections.navActionOpenGithubUserDetails(login = it.login)
                .let(findNavController()::navigate)
        }
    }
    private val binding by viewBindings(FragmentGithubUserListBinding::bind)
    private val factory by lazy(LazyThreadSafetyMode.NONE) {
        GithubUserListViewModelFactory(serviceLocator.githubUsersUseCase)
    }
    private val viewModel by viewModels<GithubUserListViewModel> { factory }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvUsers.adapter = adapter

        observe(viewModel.users, adapter::update)
    }
}
