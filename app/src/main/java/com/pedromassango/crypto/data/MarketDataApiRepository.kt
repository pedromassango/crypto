package com.pedromassango.crypto.data

import android.util.Log

class MarketDataApiRepository(
    private val marketDataService: MarketDataService) {

    private val cacheSymbols: List<Symbol>? = null

    suspend fun getSymbols(): List<Symbol>? {

        // Return data from cache if available
        cacheSymbols?.let {
            if(it.isNotEmpty()) return cacheSymbols
        }

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