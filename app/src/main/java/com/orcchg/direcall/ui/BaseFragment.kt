package com.orcchg.direcall.ui

import androidx.fragment.app.Fragment
import com.orcchg.direcall.App

abstract class BaseFragment(contentLayoutId: Int) : Fragment(contentLayoutId) {
    val serviceLocator by lazy { (requireActivity().application as App).serviceLocator }
}