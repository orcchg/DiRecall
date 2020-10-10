package com.orcchg.direcall.core.ui

import androidx.activity.ComponentActivity
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import androidx.navigation.fragment.findNavController

inline fun <reified VM : ViewModel> ComponentActivity.viewModels(
    crossinline factoryProvider: () -> BaseViewModelFactory<VM>
): Lazy<VM> =
    object : Lazy<VM> {
        private var cached: VM? = null

        override val value: VM
            get() = cached ?: ViewModelProvider(viewModelStore, factoryProvider.invoke().apply { setArguments(intent.extras) })
                .get(VM::class.java)
                .also { cached = it }

        override fun isInitialized() = cached != null
    }

@PublishedApi
internal inline fun <reified VM : ViewModel> Fragment.internalViewModels(
    crossinline factoryProvider: () -> BaseViewModelFactory<VM>,
    crossinline storeProvider: () -> ViewModelStore
): Lazy<VM> =
    object : Lazy<VM> {
        private var cached: VM? = null

        override val value: VM
            get() = cached ?: ViewModelProvider(storeProvider.invoke(), factoryProvider.invoke().apply { setArguments(arguments) })
                .get(VM::class.java)
                .also { cached = it }

        override fun isInitialized() = cached != null
    }

inline fun <reified VM : ViewModel> Fragment.viewModels(crossinline factoryProvider: () -> BaseViewModelFactory<VM>) =
    internalViewModels(factoryProvider) { viewModelStore }

inline fun <reified VM : ViewModel> Fragment.sharedViewModels(@IdRes navGraphId: Int, crossinline factoryProvider: () -> BaseViewModelFactory<VM>) =
    internalViewModels(factoryProvider) { findNavController().getViewModelStoreOwner(navGraphId).viewModelStore }

inline fun <reified VM : ViewModel> Fragment.parentViewModels(crossinline factoryProvider: () -> BaseViewModelFactory<VM>) =
    internalViewModels(factoryProvider) { requireParentFragment().viewModelStore }
