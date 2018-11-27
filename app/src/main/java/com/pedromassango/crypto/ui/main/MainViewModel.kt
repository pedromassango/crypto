package com.pedromassango.crypto.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pedromassango.crypto.data.BlockchainApiClient
import com.pedromassango.crypto.data.BlockchainStats
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val apiService = BlockchainApiClient.apiService
    val error = MutableLiveData<String>()
    val marketStats = MutableLiveData<BlockchainStats>()

    fun onLoadData() {

        GlobalScope.launch(Dispatchers.Main) {
            val response =
                    apiService.blockchainStats().await()

            if(response.isSuccessful){
                val data = response.body()
                // release the result
                marketStats.postValue(data)
            }else{
                error.postValue( response.message())
            }
        }
    }
}
