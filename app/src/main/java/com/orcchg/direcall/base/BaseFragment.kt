package com.orcchg.direcall.base

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.orcchg.direcall.domain.ServiceLocator
import com.orcchg.direcall.domain.ServiceLocatorProvider

abstract class BaseFragment(@LayoutRes layoutId: Int) : Fragment(layoutId) {

    protected val serviceLocator: ServiceLocator by lazy(LazyThreadSafetyMode.NONE) {
        (requireActivity().application as ServiceLocatorProvider).serviceLocator
    }
}
