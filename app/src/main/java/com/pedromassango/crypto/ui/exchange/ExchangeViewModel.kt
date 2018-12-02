package com.pedromassango.crypto.ui.exchange

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pedromassango.crypto.data.BlockchainApiRepository
import com.pedromassango.crypto.data.RemoteApiClients
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ExchangeViewModel(
    private val blockchainApiRepository: BlockchainApiRepository): ViewModel() {

    val error = MutableLiveData<String>()
    val exchangeResult = MutableLiveData<Double>()

    fun onExchangeClicked(currency: String,
                          valueToExchange: String) {

        GlobalScope.launch(Dispatchers.Main){
            try {
                val result = blockchainApiRepository.doExchange(currency, valueToExchange)

                when(result != null) {
                    true -> exchangeResult.postValue(result)
                    else -> error.postValue("Unable to access the server, try again later!")
                }
            } catch(e: Exception){
                error.postValue("Please check your Internet")
            }
        }
    }
}