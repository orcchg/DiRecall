package com.orcchg.direcall.ui_core_lib

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import org.kodein.di.DIAware
import org.kodein.di.instance

abstract class BaseFragment(@LayoutRes layoutId: Int) : Fragment(layoutId), DIAware {

    protected val baseDi by lazy { (requireActivity().application as DIAware).di }
    protected val factory: ViewModelProvider.Factory by instance()
}
