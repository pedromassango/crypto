package com.pedromassango.crypto.di

import com.pedromassango.crypto.data.BlockchainApiRepository
import com.pedromassango.crypto.data.MarketDataApiRepository
import com.pedromassango.crypto.data.RemoteApiClients
import com.pedromassango.crypto.ui.exchange.ExchangeViewModel
import com.pedromassango.crypto.ui.main.MainViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

object DependenciesModules {

    val appModule = module{

        factory { RemoteApiClients.blockchainService }
        factory { RemoteApiClients.marketDataService }

        factory { BlockchainApiRepository( get()) }
        factory { MarketDataApiRepository( get()) }

        viewModel{ MainViewModel(get()) }
        viewModel { ExchangeViewModel( get()) }
    }
}