package com.orcchg.direcall.ui_core_lib

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

abstract class BaseFragment(@LayoutRes layoutId: Int) : Fragment(layoutId) {

    @Inject protected lateinit var factory: ViewModelProvider.Factory
}
