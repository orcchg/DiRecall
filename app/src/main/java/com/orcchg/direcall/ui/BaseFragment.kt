package com.orcchg.direcall.ui

import androidx.fragment.app.Fragment
import com.orcchg.direcall.App

open class BaseFragment(layoutId: Int) : Fragment(layoutId) {
    val networkComponent by lazy(LazyThreadSafetyMode.NONE) { (requireActivity().application as App).networkComponent }
    val repositoryComponent by lazy(LazyThreadSafetyMode.NONE) { (requireActivity().application as App).repositoryComponent }
    val schedulerComponent by lazy(LazyThreadSafetyMode.NONE) { (requireActivity().application as App).schedulerComponent }
}