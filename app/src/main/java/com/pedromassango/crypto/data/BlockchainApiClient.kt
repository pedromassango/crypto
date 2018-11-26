package com.pedromassango.crypto.data

import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.POST
import retrofit2.http.Query

object BlockchainApiClient{

     val apiClient = Retrofit.Builder()
         .baseUrl("https://blockchain.info/")
         .addConverterFactory(GsonConverterFactory.create())
         .build()


}

interface BlockchainClient{

    @POST("tobtc")
    fun exchangeToBtc(
        @Query("currency") currency: String,
        @Query("value") valueToConvert: String
    ): Deferred<Response<Long>>
}