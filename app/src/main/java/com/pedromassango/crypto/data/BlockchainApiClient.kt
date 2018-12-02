package com.pedromassango.crypto.data

import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

object BlockchainApiClient{

    private val okHttClient = OkHttpClient.Builder()
        .readTimeout(20, TimeUnit.SECONDS)
        .connectTimeout(20, TimeUnit.SECONDS)
        .build()

     private val builder = Retrofit.Builder()
         .baseUrl("https://blockchain.info/")
         .addConverterFactory(GsonConverterFactory.create(
             GsonBuilder()
             .setLenient()
             .create())
         )
         .addCallAdapterFactory(CoroutineCallAdapterFactory())
         .client(okHttClient)
         .build()

    val apiService = builder.create(BlockchainService::class.java)
}

interface BlockchainService{

    /**
     * Convert any giving currency to Bitcoin
     *
     * @param currency the currency's name to convert to bitcoin
     * @param valueToConvert the value to convert
     */
    @POST("tobtc")
    fun exchangeToBtc(
        @Query("currency") currency: String,
        @Query("value") valueToConvert: String
    ): Deferred<Response<Double>>

    /**
     * Get the bitcoin state info
     */
    @Headers("Content-Type: application/json")
    @GET("stats")
    fun blockchainStats(): Deferred<Response<BlockchainStats>>
}