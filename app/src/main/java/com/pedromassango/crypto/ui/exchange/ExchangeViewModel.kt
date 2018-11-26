package com.pedromassango.crypto.ui.exchange

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ExchangeViewModel: ViewModel() {

    val error = MutableLiveData<String>()
    val exchangeResult = MutableLiveData<Long>()

    fun onExchangeClicked(currency: String,
                          valueToExchange: String) {

    }
}