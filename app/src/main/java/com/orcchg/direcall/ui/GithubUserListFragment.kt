package com.orcchg.direcall.ui

import android.graphics.Rect
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.orcchg.direcall.R
import com.orcchg.direcall.adapter.GithubUserListAdapter
import com.orcchg.direcall.androidutil.observe
import com.orcchg.direcall.androidutil.viewBindings
import com.orcchg.direcall.databinding.FragmentGithubUserListBinding
import com.orcchg.direcall.viewmodel.GithubUserListViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class GithubUserListFragment : Fragment(R.layout.fragment_github_user_list) {
    private val binding by viewBindings(FragmentGithubUserListBinding::bind)
    private val viewModel by viewModel<GithubUserListViewModel>()
    private val layoutManager = LinearLayoutManager(activity)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = GithubUserListAdapter()
        binding.rvItems.adapter = adapter

        binding.rvItems.addItemDecoration(object :
            DividerItemDecoration(requireContext(), layoutManager.orientation) {
            override fun getItemOffsets(
                outRect: Rect,
                view: View,
                parent: RecyclerView,
                state: RecyclerView.State
            ) {
                outRect.top = layoutManager.paddingTop
                outRect.bottom = layoutManager.paddingBottom
            }
        })

        adapter.onItemClick = {
            val action = GithubUserListFragmentDirections
                .actionNavFragmentGithubUserListToNavFragmentGithubUserDetails(it.login)

            Navigation.findNavController(binding.root).navigate(action)
        }

        observe(viewModel.userList, adapter::update)
    }
}