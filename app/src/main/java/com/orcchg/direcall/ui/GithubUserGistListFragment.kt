package com.orcchg.direcall.ui

import android.graphics.Rect
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.orcchg.direcall.App
import com.orcchg.direcall.R
import com.orcchg.direcall.adapter.GithubUserGistAdapter
import com.orcchg.direcall.androidutil.argument
import com.orcchg.direcall.androidutil.observe
import com.orcchg.direcall.androidutil.viewBindings
import com.orcchg.direcall.databinding.FragmentGithubUserGistListBinding
import com.orcchg.direcall.viewmodel.GithubUserGistListViewModel
import com.orcchg.direcall.viewmodel.GithubUserGistListViewModelFactory

class GithubUserGistListFragment : Fragment(R.layout.fragment_github_user_gist_list) {
    private val binding by viewBindings(FragmentGithubUserGistListBinding::bind)
    private val login by argument<String>("login")
    private lateinit var app: App
    private val myFactory by lazy {
        GithubUserGistListViewModelFactory(login, app.serviceLocator.get())
    }
    private val viewModel: GithubUserGistListViewModel by viewModels { myFactory }

    private val layoutManager = LinearLayoutManager(activity)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        app = requireActivity().application as App

        val adapter = GithubUserGistAdapter()
        binding.rvGistItems.adapter = adapter

        binding.rvGistItems.addItemDecoration(object :
            DividerItemDecoration(requireContext(), layoutManager.orientation) {
            override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
                outRect.top = layoutManager.paddingTop
                outRect.bottom = layoutManager.paddingBottom
            }
        })

        observe(viewModel.gistList, adapter::update)
    }
}