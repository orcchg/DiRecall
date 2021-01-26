package com.orcchg.direcall.ui

import android.content.Context
import android.graphics.Rect
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.orcchg.direcall.R
import com.orcchg.direcall.adapter.GithubUserOrgsAdapter
import com.orcchg.direcall.androidutil.argument
import com.orcchg.direcall.androidutil.observe
import com.orcchg.direcall.androidutil.viewBindings
import com.orcchg.direcall.databinding.FragmentGithubUserOrgsListBinding
import com.orcchg.direcall.di.DaggerGithubUserOrgsFeatureComponent
import com.orcchg.direcall.di.ViewModelFactoryModule
import com.orcchg.direcall.viewmodel.GithubUserOrgsListViewModel
import com.orcchg.direcall.viewmodel.GithubUserOrgsListViewModelFactory
import javax.inject.Inject

class GithubUserOrgsFragment : BaseFragment(R.layout.fragment_github_user_orgs_list) {

    override fun onAttach(context: Context) {
        DaggerGithubUserOrgsFeatureComponent
            .factory()
            .create(networkComponent, ViewModelFactoryModule(login))
            .inject(this)

        super.onAttach(context)
    }

    private val binding by viewBindings(FragmentGithubUserOrgsListBinding::bind)
    private val login by argument<String>("login")
    @Inject lateinit var myFactory : GithubUserOrgsListViewModelFactory
    private val viewModel: GithubUserOrgsListViewModel by viewModels { myFactory }
    private val layoutManager = LinearLayoutManager(activity)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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