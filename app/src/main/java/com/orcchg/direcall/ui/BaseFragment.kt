package com.orcchg.direcall.ui

import androidx.fragment.app.Fragment
import com.orcchg.direcall.App

open class BaseFragment(layoutId: Int) : Fragment(layoutId){
    val githubUserDetailsComponent = App().githubUserDetailsComponent

    val githubUsersComponent = App().githubUsersListComponent

    val githubUserFollowersComponent = App().githubUserFollowersComponent

    val githubUserGistComponent = App().githubUserGistComponent

    val githubUserOrgsComponent = App().githubUserOrgsComponent

    val githubUserReposComponent = App().githubUserReposComponent
}