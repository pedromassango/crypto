package com.pedromassango.crypto.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pedromassango.crypto.data.BlockchainStats
import com.pedromassango.crypto.data.MarketDataApiRepository

class MainViewModel(
    private val marketDataApiRepository: MarketDataApiRepository) : ViewModel() {

    val error = MutableLiveData<String>()
    val marketStats = MutableLiveData<BlockchainStats>()

    fun onLoadData() {

        /*GlobalScope.launch(Dispatchers.Main) {
            val response = blockchainService.blockchainStats().await()

            if(response.isSuccessful){
                val data = response.body()
                // release the result
                marketStats.postValue(data)
            }else{
                error.postValue( response.message())
            }
        }*/
    }
}
