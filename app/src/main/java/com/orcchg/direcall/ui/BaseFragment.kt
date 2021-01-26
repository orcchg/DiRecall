package com.orcchg.direcall.ui

import androidx.fragment.app.Fragment
import com.orcchg.direcall.App

open class BaseFragment(layoutId: Int) : Fragment(layoutId) {
    val networkComponent = App().networkComponent
}