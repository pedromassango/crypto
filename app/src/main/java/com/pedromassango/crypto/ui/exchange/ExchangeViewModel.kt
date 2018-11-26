package com.pedromassango.crypto.ui.exchange

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pedromassango.crypto.data.BlockchainApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ExchangeViewModel: ViewModel() {

    private val blockchainService = BlockchainApiClient.apiService
    val error = MutableLiveData<String>()
    val exchangeResult = MutableLiveData<Double>()

    fun onExchangeClicked(currency: String,
                          valueToExchange: String) {

        GlobalScope.launch(Dispatchers.Main){
            try {
                val response = blockchainService.exchangeToBtc(currency, valueToExchange).await()

                when(response.isSuccessful) {
                    true -> response.body().also { data ->
                        exchangeResult.postValue(data)
                    }
                    else -> error.postValue(response.message())
                }
            } catch(e: Exception){
                error.postValue("Please check your Internet")
            }
        }
    }
}