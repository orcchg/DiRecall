package com.orcchg.direcall.core.ui

import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.orcchg.direcall.base.Params
import com.orcchg.direcall.core.di.FeatureContainer
import com.orcchg.direcall.core.di.getFeature

abstract class BaseViewModelFactory<VM : ViewModel>(
    protected val featureContainer: FeatureContainer
) : ViewModelProvider.Factory {

    var params = Params.EMPTY

    protected lateinit var apiClass: Class<*>

    abstract fun create(): ViewModel

    protected inline fun <reified T> getFeature(): T {
        apiClass = T::class.java
        return featureContainer.getFeature(params)
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val vm = create()
        return if (vm is BaseViewModel) {
            vm.apply {
                apiClass = this@BaseViewModelFactory.apiClass
                featureContainer = this@BaseViewModelFactory.featureContainer
            } as T
        } else {
            vm as T
        }
    }

    fun setArguments(args: Bundle?) {
        args?.let { bundle ->
            params = Params().apply {
                bundle.keySet().forEach {
                    it of bundle.get(it)
                }
            }
        }
    }
}
