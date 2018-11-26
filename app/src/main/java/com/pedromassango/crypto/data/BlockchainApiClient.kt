package com.pedromassango.crypto.data

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.POST
import retrofit2.http.Query

object BlockchainApiClient{

     private val builder = Retrofit.Builder()
         .baseUrl("https://blockchain.info/")
         .addConverterFactory(GsonConverterFactory.create())
         .addCallAdapterFactory(CoroutineCallAdapterFactory())
         .build()

    val apiService = builder.create(BlockchainService::class.java)
}

interface BlockchainService{

    @POST("tobtc")
    fun exchangeToBtc(
        @Query("currency") currency: String,
        @Query("value") valueToConvert: String
    ): Deferred<Response<Long>>
}