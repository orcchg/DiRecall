package com.orcchg.direcall.feature.github_user_gists.impl.presentation.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.orcchg.direcall.androidutil.argument
import com.orcchg.direcall.androidutil.observe
import com.orcchg.direcall.androidutil.viewBindings
import com.orcchg.direcall.core.app.api.AppCoreLibApi
import com.orcchg.direcall.core.di.FeatureContainer
import com.orcchg.direcall.core.di.getFeature
import com.orcchg.direcall.core.ui.viewModels
import com.orcchg.direcall.feature.github_user_gists.impl.R
import com.orcchg.direcall.feature.github_user_gists.impl.databinding.FragmentGithubGistListBinding
import com.orcchg.direcall.feature.github_user_gists.impl.presentation.adapter.GithubGistsAdapter
import com.orcchg.direcall.feature.github_user_gists.impl.presentation.di.DaggerGithubUserGistsFragmentComponent
import com.orcchg.direcall.feature.github_user_gists.impl.presentation.viewmodel.GithubUserGistsViewModelFactory
import javax.inject.Inject

class GithubUserGistsFragment : Fragment(R.layout.fragment_github_gist_list) {

    @Inject lateinit var factory: GithubUserGistsViewModelFactory

    private val adapter = GithubGistsAdapter()
    private val binding by viewBindings(FragmentGithubGistListBinding::bind)
    private val login by argument<String>("login")
    private val viewModel by viewModels(::factory)

    override fun onAttach(context: Context) {
        val appCoreLibApi = (requireActivity().application as FeatureContainer).getFeature<AppCoreLibApi>()

        DaggerGithubUserGistsFragmentComponent.factory()
            .create(
                login = login,
                appCoreLibApi = appCoreLibApi
            )
            .inject(this)

        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvGists.adapter = adapter

        observe(viewModel.gists, adapter::update)
    }
}
