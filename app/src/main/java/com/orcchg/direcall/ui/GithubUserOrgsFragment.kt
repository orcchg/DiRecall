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
import com.orcchg.direcall.adapter.GithubUserOrgsAdapter
import com.orcchg.direcall.androidutil.argument
import com.orcchg.direcall.androidutil.observe
import com.orcchg.direcall.androidutil.viewBindings
import com.orcchg.direcall.databinding.FragmentGithubUserOrgsListBinding
import com.orcchg.direcall.domain.usecase.GetGithubUserOrgsUseCase
import com.orcchg.direcall.viewmodel.GithubUserOrgsListViewModel
import com.orcchg.direcall.viewmodel.GithubUserOrgsListViewModelFactory

class GithubUserOrgsFragment : Fragment(R.layout.fragment_github_user_orgs_list) {
    private val binding by viewBindings(FragmentGithubUserOrgsListBinding::bind)
    private val login by argument<String>("login")
    private lateinit var app: App
    private val useCase by lazy {
        app.serviceLocator[GetGithubUserOrgsUseCase::class.java] as GetGithubUserOrgsUseCase
    }
    private val myFactory by lazy { GithubUserOrgsListViewModelFactory(login, useCase) }
    private val viewModel: GithubUserOrgsListViewModel by viewModels { myFactory }

    private val layoutManager = LinearLayoutManager(activity)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        app = requireActivity().application as App
        val adapter = GithubUserOrgsAdapter()
        binding.rvOrganizationsItems.adapter = adapter

        binding.rvOrganizationsItems.addItemDecoration(object :
            DividerItemDecoration(requireContext(), layoutManager.orientation) {
            override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
                outRect.top = layoutManager.paddingTop
                outRect.bottom = layoutManager.paddingBottom
            }
        })

        observe(viewModel.orgsList, adapter::update)
    }
}