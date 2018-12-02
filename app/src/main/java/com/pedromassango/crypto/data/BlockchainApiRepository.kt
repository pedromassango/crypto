package com.pedromassango.crypto.data

import android.util.Log

class BlockchainApiRepository(
    private val blockchainService: BlockchainService
) {

    suspend fun doExchange(
        currency: String,
        valueToExchange: String
    ): Double? {

        try {
            val response = blockchainService.exchangeToBtc(currency, valueToExchange).await()

            when (response.isSuccessful) {
                true -> return response.body()
            }
        } catch (e: Exception) {
            e.printStackTrace()
            return null
        }
     return null
    }
}