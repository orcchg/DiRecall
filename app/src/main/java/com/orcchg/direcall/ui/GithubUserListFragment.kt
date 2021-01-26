package com.orcchg.direcall.ui

import android.content.Context
import android.graphics.Rect
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.orcchg.direcall.R
import com.orcchg.direcall.adapter.GithubUserListAdapter
import com.orcchg.direcall.androidutil.observe
import com.orcchg.direcall.androidutil.viewBindings
import com.orcchg.direcall.databinding.FragmentGithubUserListBinding
import com.orcchg.direcall.di.DaggerGithubUsersFeatureComponent
import com.orcchg.direcall.di.ViewModelFactoryModule
import com.orcchg.direcall.viewmodel.GithubUserListViewModel
import com.orcchg.direcall.viewmodel.GithubUserListViewModelFactory
import javax.inject.Inject

class GithubUserListFragment : BaseFragment(R.layout.fragment_github_user_list) {

    override fun onAttach(context: Context) {
        val component = DaggerGithubUsersFeatureComponent.builder()
            .viewModelFactoryModule(ViewModelFactoryModule())
            .networkComponent(networkComponent)
            .build()
        component.inject(this)
        super.onAttach(context)
    }

    private val binding by viewBindings(FragmentGithubUserListBinding::bind)
    @Inject lateinit var myFactory: GithubUserListViewModelFactory
    private val viewModel: GithubUserListViewModel by viewModels { myFactory }
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