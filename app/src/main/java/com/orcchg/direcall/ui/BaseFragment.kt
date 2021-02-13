package com.orcchg.direcall.ui

import android.content.Context
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.orcchg.direcall.androidutil.SchedulersFactoryImpl
import com.orcchg.direcall.base.SchedulersFactory
import com.orcchg.direcall.base.usecase.UseCaseThreadExecutor
import com.orcchg.direcall.data.di.DataModule
import com.orcchg.direcall.data.di.NetworkModule
import toothpick.ktp.KTP
import toothpick.ktp.binding.bind
import toothpick.ktp.binding.module

abstract class BaseFragment(@LayoutRes layoutRes: Int) : Fragment(layoutRes) {

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val networkModule = NetworkModule()
        val dataModule = DataModule(retrofit = networkModule.retrofit)

        KTP.openRootScope()
            .openSubScope(activity)
            .openSubScope(this)
            .installModules(
                networkModule,
                dataModule,
                module {
                    bind<SchedulersFactory>().toInstance(SchedulersFactoryImpl(UseCaseThreadExecutor()))
                }
            )
            .inject(this)
    }

    override fun onDetach() {
        super.onDetach()
        KTP.closeScope(this)
    }
}
