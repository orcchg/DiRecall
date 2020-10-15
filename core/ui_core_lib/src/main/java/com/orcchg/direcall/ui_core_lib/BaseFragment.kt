package com.orcchg.direcall.ui_core_lib

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.orcchg.direcall.service_locator.ServiceLocatorProvider

abstract class BaseFragment(@LayoutRes layoutId: Int) : Fragment(layoutId) {

    protected val serviceLocator by lazy(LazyThreadSafetyMode.NONE) {
        (requireActivity().application as ServiceLocatorProvider).serviceLocator
    }
}
