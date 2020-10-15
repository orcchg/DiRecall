package com.orcchg.direcall.ui_core_lib

import androidx.annotation.LayoutRes
import dagger.android.support.DaggerFragment

abstract class BaseFragment(@LayoutRes layoutId: Int) : DaggerFragment(layoutId)
