package com.orcchg.direcall.androidutil.di

import androidx.fragment.app.Fragment
import org.kodein.di.DI
import org.kodein.di.DIAware

fun Fragment.rootDi(): DI = (requireActivity().application as DIAware).di
