package com.orcchg.direcall.github_user_list.presentation.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.orcchg.direcall.androidutil.observe
import com.orcchg.direcall.androidutil.viewBindings
import com.orcchg.direcall.github_user_list.R
import com.orcchg.direcall.github_user_list.databinding.FragmentGithubUserListBinding
import com.orcchg.direcall.github_user_list.domain.usecase.GetGithubUsersUseCase
import com.orcchg.direcall.github_user_list.presentation.adapter.GithubUserListAdapter
import com.orcchg.direcall.github_user_list.presentation.viewmodel.GithubUserListViewModel
import com.orcchg.direcall.github_user_list.presentation.viewmodel.GithubUserListViewModelFactory
import com.orcchg.direcall.ui_core_lib.BaseFragment

class GithubUserListFragment : BaseFragment(R.layout.fragment_github_user_list) {

    private val adapter = GithubUserListAdapter().apply {
        itemClickListener = {
            GithubUserListFragmentDirections.navActionOpenGithubUserDetails(login = it.login)
                .let(findNavController()::navigate)
        }
    }
    private val binding by viewBindings(FragmentGithubUserListBinding::bind)
    private val factory by lazy(LazyThreadSafetyMode.NONE) {
        GithubUserListViewModelFactory(serviceLocator.get(GetGithubUsersUseCase::class.java))
    }
    private val viewModel by viewModels<GithubUserListViewModel> { factory }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvUsers.adapter = adapter

        observe(viewModel.users, adapter::update)
    }
}
