package com.pedromassango.crypto.data

import android.util.Log

class RemoteRepository(
    private val blockchainService: BlockchainService,
    private val marketDataService: MarketDataService) {


    suspend fun getSymbols(): List<Symbol>? {
        return try {
            val response = marketDataService.getSymbols().await()

            // show the error message
            if(!response.isSuccessful) Log.i("RemoteRepository", response.message())

            response.body()
        }catch (e: Exception){
            e.printStackTrace()
            null
        }
    }
}