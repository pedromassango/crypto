package com.pedromassango.crypto.di

import com.pedromassango.crypto.ui.exchange.ExchangeViewModel
import com.pedromassango.crypto.ui.main.MainViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

object DependenciesModules {

    val appModule = module{

        //factory { . }

        viewModel{ MainViewModel() }
        viewModel { ExchangeViewModel() }
    }
}