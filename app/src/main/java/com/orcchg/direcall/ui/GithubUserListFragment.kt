package com.orcchg.direcall.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.orcchg.direcall.R
import com.orcchg.direcall.androidutil.SchedulersFactoryImpl
import com.orcchg.direcall.androidutil.observe
import com.orcchg.direcall.androidutil.viewBindings
import com.orcchg.direcall.base.usecase.UseCaseThreadExecutor
import com.orcchg.direcall.data.convert.GithubUserDetailsCloudConverter
import com.orcchg.direcall.data.convert.GithubUserListCloudConverter
import com.orcchg.direcall.data.remote.CloudModule
import com.orcchg.direcall.data.remote.GithubUserCloudRest
import com.orcchg.direcall.data.repository.GithubRepositoryImpl
import com.orcchg.direcall.databinding.FragmentGithubUserListBinding
import com.orcchg.direcall.domain.usecase.GetGithubUsersUseCase
import com.orcchg.direcall.viewmodel.GithubUserListViewModel
import com.orcchg.direcall.viewmodel.GithubUserListViewModelFactory
import kotlinx.android.synthetic.main.fragment_github_user_list.*
import retrofit2.create

class GithubUserListFragment : Fragment(R.layout.fragment_github_user_list) {
    private val binding by viewBindings(FragmentGithubUserListBinding::bind)
    private val executor = UseCaseThreadExecutor()
    private val retrofit = CloudModule.retrofit(
        CloudModule.okHttpClient(CloudModule.loggingInterceptor()),
        CloudModule.moshi()
    )
    private val userCloud: GithubUserCloudRest = retrofit.create()
    private val userDetailsConverter = GithubUserDetailsCloudConverter()
    private val userListConverter = GithubUserListCloudConverter()
    private val scheduler = SchedulersFactoryImpl(executor)
    private val gitRepo = GithubRepositoryImpl(
        userCloud = userCloud,
        userDetailsConverter = userDetailsConverter,
        userListConverter = userListConverter
    )
    private val useCase = GetGithubUsersUseCase(gitRepo, scheduler)
    private val myFactory by lazy { GithubUserListViewModelFactory(useCase) }
    private val viewModel: GithubUserListViewModel by viewModels { myFactory }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        list_recycler_view.apply{
            layoutManager = LinearLayoutManager(activity)
            adapter = viewModel.userList.value?.let { ListAdapter(it) }
        }
    }

}