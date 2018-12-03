package com.pedromassango.crypto.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pedromassango.crypto.data.BlockchainStats
import com.pedromassango.crypto.data.MarketDataApiRepository
import com.pedromassango.crypto.data.Symbol
import com.pedromassango.crypto.data.SymbolDetails
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel(
    private val marketDataApiRepository: MarketDataApiRepository
) : ViewModel() {

    val error = MutableLiveData<String>()
    val symbols = MutableLiveData<List<Symbol>>()
    //val marketStats = MutableLiveData<BlockchainStats>()

    fun onLoadSymbols() {

        GlobalScope.launch {
            val result = marketDataApiRepository.getSymbols()

            if (result == null) {
                error.postValue("Internet Error!")
                return@launch
            }

            symbols.postValue(result)
        }

    }

    fun onLoadSymbolDetails(assetId: String): MutableLiveData<SymbolDetails?> {
        return MutableLiveData<SymbolDetails?>().apply {
            GlobalScope.launch {
                try {
                    val result = marketDataApiRepository.getSymbolDetails(assetId)
                    postValue(result)
                }catch(e: Exception){
                    e.printStackTrace()
                    error.postValue("Internet Error")
                }
            }
        }
    }
}
