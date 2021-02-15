package com.orcchg.direcall.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.orcchg.direcall.R
import com.orcchg.direcall.adapter.GithubRepoListAdapter
import com.orcchg.direcall.androidutil.argument
import com.orcchg.direcall.androidutil.di.rootDi
import com.orcchg.direcall.androidutil.observe
import com.orcchg.direcall.androidutil.viewBindings
import com.orcchg.direcall.databinding.FragmentGithubRepoListBinding
import com.orcchg.direcall.di.githubRepoFragmentModule
import com.orcchg.direcall.viewmodel.GithubRepoViewModel
import com.orcchg.direcall.viewmodel.GithubRepoViewModelFactory
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.instance

class GithubRepoFragment : Fragment(R.layout.fragment_github_repo_list), DIAware {

    private val adapter = GithubRepoListAdapter()
    private val binding by viewBindings(FragmentGithubRepoListBinding::bind)
    private val login: String by argument("login")
    private val factory: GithubRepoViewModelFactory by instance()
    private val viewModel by viewModels<GithubRepoViewModel> { factory }

    override val di: DI by DI.lazy {
        extend(rootDi())
        import(githubRepoFragmentModule(login))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvRepos.adapter = adapter

        observe(viewModel.repos, adapter::update)
    }
}
